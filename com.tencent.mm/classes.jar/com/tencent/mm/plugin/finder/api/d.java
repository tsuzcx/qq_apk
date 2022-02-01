package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder-base_release"})
public final class d
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final b wZO;
  private static final com.tencent.mm.b.h<String, d.a.a> wZP;
  public static final a wZQ;
  
  static
  {
    AppMethodBeat.i(165145);
    wZQ = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    wZO = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).getFinderContactCache();
    wZP = new com.tencent.mm.b.h(20);
    AppMethodBeat.o(165145);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderUserLogOutInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "getFinderUserLogOutInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "addLogOutInfo", "", "finderUserName", "logOutFlag", "", "logOutUrl", "checkContactCacheAvailable", "username", "delFinderNameList", "deleteCache", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getFinderNameList", "", "getLiveSettlementInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSettlementInfo;", "getLiveTaskEnable", "entrance", "getLiveTaskEntranceSubSwitch", "getLogOutInfo", "getSelf", "getSelfAlias", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "isPrivate", "isWaiting", "operationSetFollow", "followFlag", "operationSetIsNeedShowUnFollow", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "saveFinderNameList", "nameList", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "FinderUserLogOutInfo", "plugin-finder-base_release"})
  public static final class a
  {
    public static void L(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(258551);
      p.k(paramString1, "finderUserName");
      paramString2 = new a(paramInt, paramString2, cm.bfF(), 8);
      d.dng().put(paramString1, paramString2);
      ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).a(paramString1, paramString2);
      AppMethodBeat.o(258551);
    }
    
    public static boolean a(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(165140);
      p.k(paramFinderContact, "fcontact");
      Object localObject = (CharSequence)paramFinderContact.username;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(d.access$getTAG$cp(), "error FinderContact username is null " + Util.getStack());
        AppMethodBeat.o(165140);
        return false;
      }
      String str = paramFinderContact.username;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramFinderContact = c.a(paramFinderContact, aAK((String)localObject));
      d.access$getDEBUG$cp();
      Log.i(d.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { paramFinderContact.getUsername(), paramFinderContact.dnp() });
      e(paramFinderContact);
      b(paramFinderContact);
      AppMethodBeat.o(165140);
      return true;
    }
    
    private static boolean aAJ(String paramString)
    {
      AppMethodBeat.i(258536);
      Object localObject = d.dnh().aAI(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((i)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; (i != 0) || (p.h(paramString, z.bdh())); i = 0)
      {
        AppMethodBeat.o(258536);
        return false;
      }
      AppMethodBeat.o(258536);
      return true;
    }
    
    public static i aAK(String paramString)
    {
      AppMethodBeat.i(165132);
      if (paramString == null)
      {
        AppMethodBeat.o(165132);
        return null;
      }
      if (p.h(paramString, z.bdh()))
      {
        paramString = dni();
        AppMethodBeat.o(165132);
        return paramString;
      }
      if (p.h(paramString, z.bdi()))
      {
        paramString = dnj();
        AppMethodBeat.o(165132);
        return paramString;
      }
      if (aAJ(paramString))
      {
        paramString = d.dnh().aAI(paramString);
        AppMethodBeat.o(165132);
        return paramString;
      }
      i locali = aAL(paramString);
      if (locali != null) {
        e(locali);
      }
      paramString = d.dnh().aAI(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static i aAL(String paramString)
    {
      AppMethodBeat.i(165133);
      i locali = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).aab(paramString);
      String str2 = d.access$getTAG$cp();
      if (locali != null) {}
      for (String str1 = locali.dnp();; str1 = null)
      {
        Log.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return locali;
      }
    }
    
    public static boolean aAM(String paramString)
    {
      AppMethodBeat.i(165134);
      Log.d(d.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if ((paramString == null) || (Util.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((d.dnh().aAI(paramString) != null) || (aAL(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean aAN(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = d.wZQ;
        paramString = aAK(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = i.xai;
          if (i == i.dny())
          {
            AppMethodBeat.o(165143);
            return true;
          }
        }
        AppMethodBeat.o(165143);
        return false;
      }
      AppMethodBeat.o(165143);
      return false;
    }
    
    public static boolean aAO(String paramString)
    {
      AppMethodBeat.i(258550);
      if (paramString != null)
      {
        a locala = d.wZQ;
        paramString = aAK(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = i.xai;
          if (i == i.dnx())
          {
            AppMethodBeat.o(258550);
            return true;
          }
        }
        AppMethodBeat.o(258550);
        return false;
      }
      AppMethodBeat.o(258550);
      return false;
    }
    
    public static a aAP(String paramString)
    {
      AppMethodBeat.i(258554);
      p.k(paramString, "finderUserName");
      paramString = (a)d.dng().get(paramString);
      AppMethodBeat.o(258554);
      return paramString;
    }
    
    public static boolean aAQ(String paramString)
    {
      AppMethodBeat.i(258556);
      p.k(paramString, "entrance");
      boolean bool1 = com.tencent.mm.ae.d.dr((int)dni().field_liveSwitchFlag, 32);
      boolean bool2 = aAR(paramString);
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(258556);
        return true;
      }
      AppMethodBeat.o(258556);
      return false;
    }
    
    private static boolean aAR(String paramString)
    {
      AppMethodBeat.i(258558);
      String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLG, "");
      p.j(str, "configStr");
      if (((CharSequence)str).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(258558);
        return true;
      }
      try
      {
        bool = new JSONObject(str).optBoolean(paramString);
        AppMethodBeat.o(258558);
        return bool;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          boolean bool = true;
        }
      }
    }
    
    private static boolean b(i parami)
    {
      boolean bool = false;
      AppMethodBeat.i(165135);
      Object localObject1 = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).getContactStorage();
      p.k(parami, "ct");
      parami.field_updateTime = cm.bfE();
      Object localObject2;
      long l;
      int i;
      Object localObject3;
      if (((e)localObject1).aAK(parami.getUsername()) == null)
      {
        p.k(parami, "contact");
        localObject2 = parami.convertTo();
        l = SystemClock.uptimeMillis();
        i = (int)((e)localObject1).AkA.insert("FinderContact", "", (ContentValues)localObject2);
        localObject2 = new c.a();
        localObject3 = Thread.currentThread();
        p.j(localObject3, "Thread.currentThread()");
        localObject3 = ((Thread)localObject3).getName();
        p.j(localObject3, "Thread.currentThread().name");
        localObject2 = ((c.a)localObject2).aAY((String)localObject3).aAX("insertContact");
        ((c.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
        ((c.a)localObject2).aAW("FinderContactStorage.insertContact").dpk().report();
        Log.i("Finder.FinderContactStorage", "insert contact " + parami + ' ' + i);
        if (i > 0) {
          bool = true;
        }
        if (bool) {
          ((e)localObject1).doNotify("FinderContact", 4, parami.getUsername());
        }
        localObject2 = d.access$getTAG$cp();
        localObject3 = new StringBuilder("replaceContact success=").append(bool).append(' ').append(parami.getUsername()).append(' ').append(parami.dnp()).append(' ');
        if (!d.access$getDEBUG$cp()) {
          break label528;
        }
      }
      label528:
      for (localObject1 = Util.getStack();; localObject1 = "")
      {
        Log.i((String)localObject2, localObject1);
        if (bool)
        {
          localObject1 = com.tencent.mm.kernel.h.ae(n.class);
          p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          ((n)localObject1).bbL().d(i.f(parami), true);
        }
        AppMethodBeat.o(165135);
        return bool;
        p.k(parami, "contact");
        localObject2 = parami.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        l = SystemClock.uptimeMillis();
        i = ((e)localObject1).AkA.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { parami.field_username });
        localObject2 = new c.a();
        localObject3 = Thread.currentThread();
        p.j(localObject3, "Thread.currentThread()");
        localObject3 = ((Thread)localObject3).getName();
        p.j(localObject3, "Thread.currentThread().name");
        localObject2 = ((c.a)localObject2).aAY((String)localObject3).aAX("updateContact");
        ((c.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
        ((c.a)localObject2).aAW("FinderContactStorage.updateContact").dpk().report();
        Log.i("Finder.FinderContactStorage", "updateContact " + parami.dnq() + ' ' + i);
        if (i <= 0) {
          break;
        }
        bool = true;
        break;
      }
    }
    
    public static boolean b(FinderContact paramFinderContact)
    {
      Object localObject3 = null;
      AppMethodBeat.i(165141);
      if (paramFinderContact == null)
      {
        AppMethodBeat.o(165141);
        return false;
      }
      Object localObject1 = (CharSequence)paramFinderContact.username;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(d.access$getTAG$cp(), "error FinderContact username is null " + Util.getStack());
        AppMethodBeat.o(165141);
        return false;
      }
      Object localObject2 = paramFinderContact.username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = aAK((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new i();
      }
      Object localObject4 = paramFinderContact.username;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((i)localObject1).setUsername((String)localObject2);
      localObject4 = paramFinderContact.headUrl;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((i)localObject1).aAS((String)localObject2);
      localObject4 = paramFinderContact.nickname;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((i)localObject1).setNickname((String)localObject2);
      localObject4 = ((i)localObject1).field_authInfo;
      if (localObject4 != null) {
        if (paramFinderContact.authInfo != null)
        {
          localObject2 = paramFinderContact.authInfo;
          if (localObject2 != null)
          {
            localObject2 = ((FinderAuthInfo)localObject2).appName;
            ((FinderAuthInfo)localObject4).appName = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label612;
            }
            localObject2 = ((FinderAuthInfo)localObject2).authProfession;
            label236:
            ((FinderAuthInfo)localObject4).authProfession = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label617;
            }
            i = ((FinderAuthInfo)localObject2).authIconType;
            label256:
            ((FinderAuthInfo)localObject4).authIconType = i;
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label622;
            }
            localObject2 = ((FinderAuthInfo)localObject2).detailLink;
            label276:
            ((FinderAuthInfo)localObject4).detailLink = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label627;
            }
            localObject2 = ((FinderAuthInfo)localObject2).realName;
            label296:
            ((FinderAuthInfo)localObject4).realName = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label632;
            }
            localObject2 = ((FinderAuthInfo)localObject2).authIconUrl;
            label316:
            ((FinderAuthInfo)localObject4).authIconUrl = ((String)localObject2);
          }
        }
        else
        {
          label322:
          ((i)localObject1).field_extInfo = paramFinderContact.extInfo;
          if (!d.access$getDEBUG$cp()) {
            break label663;
          }
          localObject4 = d.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("replaceMinContact fcontact : ");
          p.k(paramFinderContact, "$this$info");
          Object localObject5 = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
          localObject2 = paramFinderContact.authInfo;
          if (localObject2 == null) {
            break label648;
          }
          localObject2 = ((FinderAuthInfo)localObject2).realName;
          label425:
          localObject5 = ((StringBuilder)localObject5).append((String)localObject2).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
          localObject2 = paramFinderContact.headUrl;
          if (localObject2 == null) {
            break label653;
          }
          localObject2 = Integer.valueOf(((String)localObject2).length());
          label469:
          localObject5 = ((StringBuilder)localObject5).append(localObject2).append(", originalFlag:").append(paramFinderContact.originalFlag).append(" ,spam:").append(paramFinderContact.spamStatus).append(", liveAnchorStatus:");
          localObject2 = paramFinderContact.live_info;
          if (localObject2 == null) {
            break label658;
          }
          localObject2 = Long.valueOf(((arf)localObject2).SEj);
          label526:
          localObject2 = ((StringBuilder)localObject5).append(localObject2).append(", liveSwitchFlag:");
          localObject5 = paramFinderContact.live_info;
          paramFinderContact = localObject3;
          if (localObject5 != null) {
            paramFinderContact = Integer.valueOf(((arf)localObject5).SEk);
          }
          Log.i((String)localObject4, ((StringBuilder)localObject2).append(paramFinderContact).toString() + "  from " + Util.getStack());
        }
      }
      for (;;)
      {
        e((i)localObject1);
        AppMethodBeat.o(165141);
        return true;
        localObject2 = null;
        break;
        label612:
        localObject2 = null;
        break label236;
        label617:
        i = 0;
        break label256;
        label622:
        localObject2 = null;
        break label276;
        label627:
        localObject2 = null;
        break label296;
        label632:
        localObject2 = null;
        break label316;
        ((i)localObject1).field_authInfo = paramFinderContact.authInfo;
        break label322;
        label648:
        localObject2 = null;
        break label425;
        label653:
        localObject2 = null;
        break label469;
        label658:
        localObject2 = null;
        break label526;
        label663:
        Log.i(d.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((i)localObject1).dnq() });
      }
    }
    
    public static boolean c(i parami)
    {
      AppMethodBeat.i(165136);
      p.k(parami, "contact");
      String str = d.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(parami.getUsername()).append(' ').append(parami.dnp()).append(' ');
      if (d.access$getDEBUG$cp()) {}
      for (Object localObject = Util.getStack();; localObject = "")
      {
        Log.i(str, localObject);
        if (!aAM(parami.getUsername())) {
          break;
        }
        e(parami);
        if (aAL(parami.getUsername()) != null)
        {
          localObject = d.wZQ;
          b(parami);
        }
        AppMethodBeat.o(165136);
        return true;
      }
      AppMethodBeat.o(165136);
      return false;
    }
    
    public static boolean d(i parami)
    {
      AppMethodBeat.i(258547);
      p.k(parami, "contact");
      e(parami);
      boolean bool = b(parami);
      AppMethodBeat.o(258547);
      return bool;
    }
    
    public static void dP(String paramString, int paramInt)
    {
      AppMethodBeat.i(258545);
      p.k(paramString, "finderUserName");
      Object localObject2 = d.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramInt).append(" and cacheItem ");
      Object localObject1 = d.dnh().aAI(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((i)localObject1).dnp();; localObject1 = null)
      {
        Log.i((String)localObject2, (String)localObject1);
        localObject3 = (kotlin.g.a.b)new b(paramInt);
        localObject2 = aAK(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new i();
          ((i)localObject1).field_username = paramString;
        }
        paramString = (i)((kotlin.g.a.b)localObject3).invoke(localObject1);
        e(paramString);
        b(paramString);
        AppMethodBeat.o(258545);
        return;
      }
    }
    
    public static void dV(List<String> paramList)
    {
      AppMethodBeat.i(258534);
      ArrayList localArrayList = new ArrayList();
      int i;
      if (paramList != null)
      {
        if (((Collection)paramList).isEmpty()) {
          break label107;
        }
        i = 1;
        if (i == 0) {
          break label112;
        }
      }
      label107:
      label112:
      for (Object localObject = paramList;; localObject = null)
      {
        if (localObject != null) {
          localArrayList.addAll((Collection)paramList);
        }
        paramList = Util.listToString((List)localArrayList, ",");
        Log.i(d.access$getTAG$cp(), "[saveFinderNameList] name list:".concat(String.valueOf(paramList)));
        localObject = com.tencent.mm.kernel.h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((f)localObject).aHp().set(ar.a.Vzc, paramList);
        AppMethodBeat.o(258534);
        return;
        i = 0;
        break;
      }
    }
    
    public static i dni()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = d.dnh();
      Object localObject2 = z.bdh();
      p.j(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((b)localObject1).aAI((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new i();
        ((i)localObject1).field_username = z.bdh();
      }
      for (;;)
      {
        localObject2 = i.xai;
        ((i)localObject1).field_follow_Flag = i.dny();
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.VxY, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).field_nickname = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.Vya, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.Vyc, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.VxZ, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).field_signature = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        ((i)localObject1).field_originalFlag = ((f)localObject2).aHp().getInt(ar.a.Vyl, 0);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        ((i)localObject1).field_originalEntranceFlag = ((f)localObject2).aHp().getInt(ar.a.Vyq, 0);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        ((i)localObject1).field_extFlag = ((f)localObject2).aHp().getInt(ar.a.Vzn, 0);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.Vyb, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject4 = (String)localObject2;
        if (!Util.isNullOrNil((String)localObject4))
        {
          ((i)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (a)((i)localObject1).field_authInfo;
          localObject4 = Util.decodeHexString((String)localObject4);
        }
        for (;;)
        {
          try
          {
            ((a)localObject2).parseFrom((byte[])localObject4);
            localObject2 = com.tencent.mm.kernel.h.aHG();
            p.j(localObject2, "MMKernel.storage()");
            localObject2 = ((f)localObject2).aHp().get(ar.a.VyI, "");
            if (localObject2 != null) {
              break;
            }
            localObject1 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(165131);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException });
            continue;
          }
          ((i)localObject1).field_authInfo = null;
        }
        ((i)localObject1).field_liveCoverImg = ((String)localException);
        Object localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((i)localObject1).field_liveAnchorStatusFlag = ((f)localObject3).aHp().a(ar.a.VyJ, 0L);
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((i)localObject1).field_liveSwitchFlag = ((f)localObject3).aHp().a(ar.a.VyK, 0L);
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((i)localObject1).field_liveMicSetting = ((f)localObject3).aHp().a(ar.a.VyQ, 0L);
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((i)localObject1).field_liveMicSettingSwitch = ((f)localObject3).aHp().a(ar.a.VyL, 0L);
        localObject3 = new egt();
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        ((egt)localObject3).jDP = ((f)localObject4).aHp().a(ar.a.VyN, "");
        localObject4 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject4, "MMKernel.storage()");
        ((egt)localObject3).SNP = ((f)localObject4).aHp().a(ar.a.VyM, "");
        ((i)localObject1).field_settlementInfo = ((egt)localObject3);
        localObject3 = new dt();
        localObject4 = new du();
        f localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        ((du)localObject4).RJk = localf.aHp().a(ar.a.VyO, "");
        localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        ((du)localObject4).jump_url = localf.aHp().a(ar.a.VyP, "");
        ((dt)localObject3).RJj = ((du)localObject4);
        ((i)localObject1).field_agencyCollaborateInfo = ((dt)localObject3);
        AppMethodBeat.o(165131);
        return localObject1;
      }
    }
    
    public static i dnj()
    {
      AppMethodBeat.i(258533);
      Object localObject1 = d.dnh();
      Object localObject2 = z.bdi();
      p.j(localObject2, "ConfigStorageLogic.getMyFinderAliasUsername()");
      localObject1 = ((b)localObject1).aAI((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new i();
        ((i)localObject1).field_username = z.bdi();
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.Vye, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(258533);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).setNickname((String)localObject2);
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((f)localObject2).aHp().get(ar.a.Vyf, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(258533);
          throw ((Throwable)localObject1);
        }
        ((i)localObject1).aAS((String)localObject2);
        AppMethodBeat.o(258533);
        return localObject1;
      }
    }
    
    public static List<String> dnk()
    {
      AppMethodBeat.i(258535);
      Object localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((f)localObject).aHp().a(ar.a.Vzc, "");
      Log.i(d.access$getTAG$cp(), "[getFinderNameList] name list:".concat(String.valueOf(localObject)));
      localObject = (List)new ArrayList((Collection)Util.stringToList((String)localObject, ","));
      AppMethodBeat.o(258535);
      return localObject;
    }
    
    public static void e(i parami)
    {
      AppMethodBeat.i(165142);
      String str = parami.getUsername();
      d.dnh().a(str, parami);
      parami = com.tencent.mm.kernel.h.ae(n.class);
      p.j(parami, "MMKernel.service(IMessengerStorage::class.java)");
      ((n)parami).bbL().aHy(str);
      AppMethodBeat.o(165142);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "", "logOutFlag", "", "logOutUrl", "", "timeStamp", "hasLogOut", "", "(ILjava/lang/String;IZ)V", "getHasLogOut", "()Z", "setHasLogOut", "(Z)V", "getLogOutFlag", "()I", "setLogOutFlag", "(I)V", "getLogOutUrl", "()Ljava/lang/String;", "setLogOutUrl", "(Ljava/lang/String;)V", "getTimeStamp", "setTimeStamp", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-base_release"})
    public static final class a
    {
      public int wZR;
      public String wZS;
      private int wZT;
      public boolean wZU;
      
      public a()
      {
        this(0, null, 0, 15);
      }
      
      private a(int paramInt1, String paramString, int paramInt2)
      {
        this.wZR = paramInt1;
        this.wZS = paramString;
        this.wZT = paramInt2;
        this.wZU = false;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(263620);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.wZR != paramObject.wZR) || (!p.h(this.wZS, paramObject.wZS)) || (this.wZT != paramObject.wZT) || (this.wZU != paramObject.wZU)) {}
          }
        }
        else
        {
          AppMethodBeat.o(263620);
          return true;
        }
        AppMethodBeat.o(263620);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(263616);
        String str = "FinderUserLogOutInfo(logOutFlag=" + this.wZR + ", logOutUrl=" + this.wZS + ", timeStamp=" + this.wZT + ", hasLogOut=" + this.wZU + ")";
        AppMethodBeat.o(263616);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<i, i>
    {
      b(int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d
 * JD-Core Version:    0.7.0.1
 */