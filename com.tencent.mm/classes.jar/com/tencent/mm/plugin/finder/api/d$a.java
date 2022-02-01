package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderUserLogOutInfoCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "getFinderUserLogOutInfoCache", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "addLogOutInfo", "", "finderUserName", "logOutFlag", "", "logOutUrl", "checkContactCacheAvailable", "username", "delFinderNameList", "deleteCache", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getFinderNameList", "", "getLiveSettlementInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSettlementInfo;", "getLiveTaskEnable", "entrance", "getLiveTaskEntranceSubSwitch", "getLogOutInfo", "getSelf", "getSelfAlias", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "bizUsername", "onlyCheckFinderFollow", "ignoreOneTimeFlag", "isNeedShowUnFollow", "isPrivate", "isWaiting", "operationSetFollow", "followFlag", "operationSetIsNeedShowUnFollow", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "saveFinderNameList", "nameList", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "FinderUserLogOutInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  public static void N(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(330119);
    s.u(paramString1, "finderUserName");
    paramString2 = new a(paramInt, paramString2, cn.getSyncServerTimeSecond(), 8);
    d.dUa().put(paramString1, paramString2);
    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(paramString1, paramString2);
    AppMethodBeat.o(330119);
  }
  
  public static boolean St(String paramString)
  {
    AppMethodBeat.i(330111);
    if (paramString == null)
    {
      AppMethodBeat.o(330111);
      return false;
    }
    a locala = d.AwY;
    paramString = auT(paramString);
    if (paramString != null)
    {
      int i = paramString.field_follow_Flag;
      paramString = m.Axk;
      if (i == m.dUF())
      {
        AppMethodBeat.o(330111);
        return true;
      }
    }
    AppMethodBeat.o(330111);
    return false;
  }
  
  private static boolean auS(String paramString)
  {
    AppMethodBeat.i(329987);
    Object localObject = d.dUb().auR(paramString);
    if (localObject != null)
    {
      localObject = (CharSequence)((m)localObject).field_username;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label61;
      }
    }
    label61:
    for (int i = 1; (i != 0) || (s.p(paramString, z.bAW())); i = 0)
    {
      AppMethodBeat.o(329987);
      return false;
    }
    AppMethodBeat.o(329987);
    return true;
  }
  
  public static m auT(String paramString)
  {
    AppMethodBeat.i(165132);
    if (paramString == null)
    {
      AppMethodBeat.o(165132);
      return null;
    }
    if (s.p(paramString, z.bAW()))
    {
      paramString = dUc();
      AppMethodBeat.o(165132);
      return paramString;
    }
    if (s.p(paramString, z.bAX()))
    {
      paramString = dUd();
      AppMethodBeat.o(165132);
      return paramString;
    }
    if (auS(paramString))
    {
      paramString = d.dUb().auR(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    m localm = auU(paramString);
    if (localm != null) {
      f(localm);
    }
    paramString = d.dUb().auR(paramString);
    AppMethodBeat.o(165132);
    return paramString;
  }
  
  private static m auU(String paramString)
  {
    AppMethodBeat.i(165133);
    m localm = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).So(paramString);
    String str2 = d.access$getTAG$cp();
    if (localm == null) {}
    for (String str1 = null;; str1 = localm.bRT())
    {
      Log.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
      AppMethodBeat.o(165133);
      return localm;
    }
  }
  
  public static boolean auV(String paramString)
  {
    AppMethodBeat.i(165134);
    Log.d(d.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(165134);
      return false;
    }
    if ((d.dUb().auR(paramString) != null) || (auU(paramString) != null))
    {
      AppMethodBeat.o(165134);
      return true;
    }
    AppMethodBeat.o(165134);
    return false;
  }
  
  public static a auW(String paramString)
  {
    AppMethodBeat.i(330122);
    s.u(paramString, "finderUserName");
    paramString = (a)d.dUa().get(paramString);
    AppMethodBeat.o(330122);
    return paramString;
  }
  
  public static boolean auX(String paramString)
  {
    AppMethodBeat.i(330130);
    s.u(paramString, "entrance");
    boolean bool1 = com.tencent.mm.ae.d.ee((int)dUc().field_liveSwitchFlag, 32);
    boolean bool2 = auY(paramString);
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(330130);
      return true;
    }
    AppMethodBeat.o(330130);
    return false;
  }
  
  private static boolean auY(String paramString)
  {
    AppMethodBeat.i(330140);
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zcj, "");
    s.s(str, "configStr");
    if (((CharSequence)str).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330140);
      return true;
    }
    try
    {
      bool = new JSONObject(str).optBoolean(paramString);
      AppMethodBeat.o(330140);
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
  
  private static boolean c(m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(165135);
    Object localObject1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).getContactStorage();
    s.u(paramm, "ct");
    paramm.field_updateTime = cn.bDw();
    Object localObject2;
    long l;
    int i;
    Object localObject3;
    if (((com.tencent.mm.plugin.finder.storage.f)localObject1).auT(paramm.getUsername()) == null)
    {
      s.u(paramm, "contact");
      localObject2 = paramm.convertTo();
      l = SystemClock.uptimeMillis();
      i = (int)((com.tencent.mm.plugin.finder.storage.f)localObject1).psb.insert("FinderContact", "", (ContentValues)localObject2);
      localObject2 = new a.a();
      localObject3 = Thread.currentThread().getName();
      s.s(localObject3, "currentThread().name");
      localObject2 = ((a.a)localObject2).avh((String)localObject3).avg("insertContact");
      ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
      ((a.a)localObject2).avf("FinderContactStorage.insertContact").dWL().report();
      Log.i("Finder.FinderContactStorage", "insert contact " + paramm + ' ' + i);
      if (i > 0) {
        bool = true;
      }
      if (bool) {
        ((com.tencent.mm.plugin.finder.storage.f)localObject1).doNotify("FinderContact", 4, paramm.getUsername());
      }
      localObject2 = d.access$getTAG$cp();
      localObject3 = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramm.getUsername()).append(' ').append(paramm.bRT()).append(' ');
      if (!d.access$getDEBUG$cp()) {
        break label486;
      }
    }
    label486:
    for (localObject1 = Util.getStack();; localObject1 = "")
    {
      Log.i((String)localObject2, localObject1);
      if (bool) {
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(m.g(paramm), true);
      }
      AppMethodBeat.o(165135);
      return bool;
      s.u(paramm, "contact");
      localObject2 = paramm.convertTo();
      ((ContentValues)localObject2).remove("rowid");
      l = SystemClock.uptimeMillis();
      i = ((com.tencent.mm.plugin.finder.storage.f)localObject1).psb.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { s.X("", paramm.field_username) });
      localObject2 = new a.a();
      localObject3 = Thread.currentThread().getName();
      s.s(localObject3, "currentThread().name");
      localObject2 = ((a.a)localObject2).avh((String)localObject3).avg("updateContact");
      ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
      ((a.a)localObject2).avf("FinderContactStorage.updateContact").dWL().report();
      Log.i("Finder.FinderContactStorage", "updateContact " + paramm.dUw() + ' ' + i);
      if (i <= 0) {
        break;
      }
      bool = true;
      break;
    }
  }
  
  public static boolean d(m paramm)
  {
    AppMethodBeat.i(165136);
    s.u(paramm, "contact");
    String str = d.access$getTAG$cp();
    StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramm.getUsername()).append(' ').append(paramm.bRT()).append(' ');
    if (d.access$getDEBUG$cp()) {}
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.i(str, localObject);
      if (!auV(paramm.getUsername())) {
        break;
      }
      f(paramm);
      if (auU(paramm.getUsername()) != null)
      {
        localObject = d.AwY;
        c(paramm);
      }
      AppMethodBeat.o(165136);
      return true;
    }
    AppMethodBeat.o(165136);
    return false;
  }
  
  public static boolean d(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(165140);
    s.u(paramFinderContact, "fcontact");
    Object localObject = (CharSequence)paramFinderContact.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e(d.access$getTAG$cp(), s.X("error FinderContact username is null ", Util.getStack()));
      AppMethodBeat.o(165140);
      return false;
    }
    String str = paramFinderContact.username;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramFinderContact = c.a(paramFinderContact, auT((String)localObject), true);
    d.access$getDEBUG$cp();
    Log.i(d.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { paramFinderContact.getUsername(), paramFinderContact.bRT() });
    f(paramFinderContact);
    c(paramFinderContact);
    AppMethodBeat.o(165140);
    return true;
  }
  
  public static m dUc()
  {
    AppMethodBeat.i(165131);
    Object localObject1 = d.dUb();
    Object localObject2 = z.bAW();
    s.s(localObject2, "getMyFinderUsername()");
    localObject1 = ((b)localObject1).auR((String)localObject2);
    if (localObject1 == null)
    {
      localObject1 = new m();
      ((m)localObject1).field_username = z.bAW();
    }
    for (;;)
    {
      localObject2 = m.Axk;
      ((m)localObject1).field_follow_Flag = m.dUG();
      localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZS, "");
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165131);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).field_nickname = ((String)localObject2);
    localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZU, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165131);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).field_avatarUrl = ((String)localObject2);
    localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZW, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165131);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).field_coverImg = ((String)localObject2);
    localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZT, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165131);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).field_signature = ((String)localObject2);
    ((m)localObject1).field_originalFlag = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adag, 0);
    ((m)localObject1).field_originalEntranceFlag = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adal, 0);
    ((m)localObject1).field_extFlag = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
    localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZV, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165131);
      throw ((Throwable)localObject1);
    }
    Object localObject4 = (String)localObject2;
    if (!Util.isNullOrNil((String)localObject4))
    {
      ((m)localObject1).field_authInfo = new FinderAuthInfo();
      localObject2 = (a)((m)localObject1).field_authInfo;
      localObject4 = Util.decodeHexString((String)localObject4);
    }
    for (;;)
    {
      try
      {
        ((a)localObject2).parseFrom((byte[])localObject4);
        localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaE, "");
        if (localObject2 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165131);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
      }
      ((m)localObject1).field_authInfo = null;
    }
    ((m)localObject1).field_liveCoverImg = ((String)localException);
    ((m)localObject1).field_liveAnchorStatusFlag = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaF, 0L);
    ((m)localObject1).field_liveSwitchFlag = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaG, 0L);
    ((m)localObject1).field_liveMicSetting = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaM, 0L);
    ((m)localObject1).field_liveMicSettingSwitch = com.tencent.mm.kernel.h.baE().ban().a(at.a.adaH, 0L);
    Object localObject3 = new fat();
    ((fat)localObject3).mdK = com.tencent.mm.kernel.h.baE().ban().b(at.a.adaJ, "");
    ((fat)localObject3).ZVg = com.tencent.mm.kernel.h.baE().ban().b(at.a.adaI, "");
    localObject4 = ah.aiuX;
    ((m)localObject1).field_settlementInfo = ((fat)localObject3);
    localObject3 = new ei();
    localObject4 = new ej();
    ((ej)localObject4).YGx = com.tencent.mm.kernel.h.baE().ban().b(at.a.adaK, "");
    ((ej)localObject4).jump_url = com.tencent.mm.kernel.h.baE().ban().b(at.a.adaL, "");
    ah localah = ah.aiuX;
    ((ei)localObject3).YGw = ((ej)localObject4);
    localObject4 = ah.aiuX;
    ((m)localObject1).field_agencyCollaborateInfo = ((ei)localObject3);
    AppMethodBeat.o(165131);
    return localObject1;
  }
  
  public static m dUd()
  {
    AppMethodBeat.i(329962);
    Object localObject1 = d.dUb();
    Object localObject2 = z.bAX();
    s.s(localObject2, "getMyFinderAliasUsername()");
    localObject1 = ((b)localObject1).auR((String)localObject2);
    if (localObject1 == null)
    {
      localObject1 = new m();
      ((m)localObject1).field_username = z.bAX();
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZZ, "");
      if (localObject2 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(329962);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).setNickname((String)localObject2);
    localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaa, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(329962);
      throw ((Throwable)localObject1);
    }
    ((m)localObject1).auZ((String)localObject2);
    AppMethodBeat.o(329962);
    return localObject1;
  }
  
  public static List<String> dUe()
  {
    AppMethodBeat.i(329974);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().b(at.a.adbd, "");
    Log.i(d.access$getTAG$cp(), s.X("[getFinderNameList] name list:", localObject));
    localObject = (List)new ArrayList((Collection)Util.stringToList((String)localObject, ","));
    AppMethodBeat.o(329974);
    return localObject;
  }
  
  public static void dUf()
  {
    AppMethodBeat.i(329980);
    Log.i(d.access$getTAG$cp(), "[delFinderNameList]");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adbd, "");
    AppMethodBeat.o(329980);
  }
  
  public static ArrayList<m> dUg()
  {
    AppMethodBeat.i(330016);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new StringBuilder("SELECT * FROM FinderContact WHERE follow_Flag = ");
    Object localObject2 = m.Axk;
    localObject1 = ((StringBuilder)localObject1).append(m.dUG()).append(" AND user_flag = ");
    localObject2 = m.Axk;
    localObject1 = m.dUI() + " ORDER BY followTime DESC LIMIT 2147483647";
    localObject1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).getContactStorage().rawQuery((String)localObject1, new String[0]);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject1).moveToNext() == true)
        {
          i = 1;
          if (i == 0) {
            break label152;
          }
          localObject2 = new m();
          ((m)localObject2).convertFrom((Cursor)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(330016);
      }
      int i = 0;
    }
    label152:
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    Log.i(d.access$getTAG$cp(), s.X("selectFollowedContact result: ", Integer.valueOf(localArrayList1.size())));
    AppMethodBeat.o(330016);
    return localArrayList1;
  }
  
  public static boolean e(m paramm)
  {
    AppMethodBeat.i(330050);
    s.u(paramm, "contact");
    f(paramm);
    boolean bool = c(paramm);
    AppMethodBeat.o(330050);
    return bool;
  }
  
  public static boolean e(FinderContact paramFinderContact)
  {
    Object localObject4 = null;
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
      Log.e(d.access$getTAG$cp(), s.X("error FinderContact username is null ", Util.getStack()));
      AppMethodBeat.o(165141);
      return false;
    }
    Object localObject2 = paramFinderContact.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = auT((String)localObject1);
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new m();
    }
    Object localObject5 = c.b(paramFinderContact);
    localObject2 = paramFinderContact.username;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((m)localObject3).setUsername((String)localObject1);
    if (localObject5 == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramFinderContact.headUrl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      ((m)localObject3).auZ((String)localObject1);
      if (localObject5 != null) {
        break label526;
      }
      localObject2 = null;
      label180:
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramFinderContact.nickname;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      ((m)localObject3).setNickname((String)localObject1);
      localObject2 = ((m)localObject3).field_authInfo;
      if (localObject2 != null) {
        break label535;
      }
      localObject1 = null;
      if (localObject1 == null) {
        ((m)localObject3).field_authInfo = paramFinderContact.authInfo;
      }
      ((m)localObject3).field_extInfo = paramFinderContact.extInfo;
      localObject1 = new aud();
      ((aud)localObject1).bind_info = paramFinderContact.bind_info;
      localObject2 = ah.aiuX;
      ((m)localObject3).field_bindInfoList = ((aud)localObject1);
      if (!d.access$getDEBUG$cp()) {
        break label734;
      }
      localObject2 = d.access$getTAG$cp();
      localObject5 = new StringBuilder("replaceMinContact fcontact : ");
      s.u(paramFinderContact, "<this>");
      StringBuilder localStringBuilder = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
      localObject1 = paramFinderContact.authInfo;
      if (localObject1 != null) {
        break label693;
      }
      localObject1 = null;
      label358:
      localStringBuilder = localStringBuilder.append(localObject1).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
      localObject1 = paramFinderContact.headUrl;
      if (localObject1 != null) {
        break label701;
      }
      localObject1 = null;
      label396:
      localStringBuilder = localStringBuilder.append(localObject1).append(", originalFlag:").append(paramFinderContact.originalFlag).append(" ,spam:").append(paramFinderContact.spamStatus).append(", liveAnchorStatus:");
      localObject1 = paramFinderContact.live_info;
      if (localObject1 != null) {
        break label712;
      }
      localObject1 = null;
      label447:
      localObject1 = localStringBuilder.append(localObject1).append(", liveSwitchFlag:");
      paramFinderContact = paramFinderContact.live_info;
      if (paramFinderContact != null) {
        break label723;
      }
      paramFinderContact = localObject4;
      label472:
      Log.i((String)localObject2, ((StringBuilder)localObject1).append(paramFinderContact).toString() + "  from " + Util.getStack());
    }
    for (;;)
    {
      f((m)localObject3);
      AppMethodBeat.o(165141);
      return true;
      localObject2 = ((pu)localObject5).xkY;
      break;
      label526:
      localObject2 = ((pu)localObject5).YTl;
      break label180;
      label535:
      if (paramFinderContact.authInfo != null)
      {
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label645;
        }
        localObject1 = null;
        label553:
        ((FinderAuthInfo)localObject2).appName = ((String)localObject1);
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label653;
        }
        localObject1 = null;
        label569:
        ((FinderAuthInfo)localObject2).authProfession = ((String)localObject1);
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label661;
        }
        i = 0;
        label585:
        ((FinderAuthInfo)localObject2).authIconType = i;
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label669;
        }
        localObject1 = null;
        label601:
        ((FinderAuthInfo)localObject2).detailLink = ((String)localObject1);
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label677;
        }
        localObject1 = null;
        label617:
        ((FinderAuthInfo)localObject2).realName = ((String)localObject1);
        localObject1 = paramFinderContact.authInfo;
        if (localObject1 != null) {
          break label685;
        }
      }
      label645:
      label653:
      label661:
      label669:
      label677:
      label685:
      for (localObject1 = null;; localObject1 = ((FinderAuthInfo)localObject1).authIconUrl)
      {
        ((FinderAuthInfo)localObject2).authIconUrl = ((String)localObject1);
        localObject1 = ah.aiuX;
        break;
        localObject1 = ((FinderAuthInfo)localObject1).appName;
        break label553;
        localObject1 = ((FinderAuthInfo)localObject1).authProfession;
        break label569;
        i = ((FinderAuthInfo)localObject1).authIconType;
        break label585;
        localObject1 = ((FinderAuthInfo)localObject1).detailLink;
        break label601;
        localObject1 = ((FinderAuthInfo)localObject1).realName;
        break label617;
      }
      label693:
      localObject1 = ((FinderAuthInfo)localObject1).realName;
      break label358;
      label701:
      localObject1 = Integer.valueOf(((String)localObject1).length());
      break label396;
      label712:
      localObject1 = Long.valueOf(((avn)localObject1).ZFH);
      break label447;
      label723:
      paramFinderContact = Integer.valueOf(paramFinderContact.ZFI);
      break label472;
      label734:
      Log.i(d.access$getTAG$cp(), s.X("replaceMinContact result %s onlyMemory ", Boolean.TRUE), new Object[] { ((m)localObject3).dUw() });
    }
  }
  
  public static void et(String paramString, int paramInt)
  {
    AppMethodBeat.i(330044);
    s.u(paramString, "finderUserName");
    Object localObject2 = d.access$getTAG$cp();
    Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramInt).append(" and cacheItem ");
    Object localObject1 = d.dUb().auR(paramString);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((m)localObject1).bRT())
    {
      Log.i((String)localObject2, localObject1);
      localObject3 = (kotlin.g.a.b)new b(paramInt);
      localObject2 = auT(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new m();
        ((m)localObject1).field_username = paramString;
      }
      paramString = (m)((kotlin.g.a.b)localObject3).invoke(localObject1);
      f(paramString);
      c(paramString);
      AppMethodBeat.o(330044);
      return;
    }
  }
  
  public static void f(m paramm)
  {
    AppMethodBeat.i(165142);
    String str = paramm.getUsername();
    d.dUb().a(str, paramm);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().aDW(str);
    AppMethodBeat.o(165142);
  }
  
  public static void fS(List<String> paramList)
  {
    AppMethodBeat.i(329969);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramList != null)
    {
      if (((Collection)paramList).isEmpty()) {
        break label95;
      }
      i = 1;
      if (i == 0) {
        break label100;
      }
    }
    label95:
    label100:
    for (List<String> localList = paramList;; localList = null)
    {
      if (localList != null) {
        localArrayList.addAll((Collection)paramList);
      }
      paramList = Util.listToString((List)localArrayList, ",");
      Log.i(d.access$getTAG$cp(), s.X("[saveFinderNameList] name list:", paramList));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbd, paramList);
      AppMethodBeat.o(329969);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "", "logOutFlag", "", "logOutUrl", "", "timeStamp", "hasLogOut", "", "(ILjava/lang/String;IZ)V", "getHasLogOut", "()Z", "setHasLogOut", "(Z)V", "getLogOutFlag", "()I", "setLogOutFlag", "(I)V", "getLogOutUrl", "()Ljava/lang/String;", "setLogOutUrl", "(Ljava/lang/String;)V", "getTimeStamp", "setTimeStamp", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int Axb;
    public String Axc;
    private int Axd;
    public boolean Axe;
    
    public a()
    {
      this(0, null, 0, 15);
    }
    
    private a(int paramInt1, String paramString, int paramInt2)
    {
      this.Axb = paramInt1;
      this.Axc = paramString;
      this.Axd = paramInt2;
      this.Axe = false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(329957);
      if (this == paramObject)
      {
        AppMethodBeat.o(329957);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(329957);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.Axb != paramObject.Axb)
      {
        AppMethodBeat.o(329957);
        return false;
      }
      if (!s.p(this.Axc, paramObject.Axc))
      {
        AppMethodBeat.o(329957);
        return false;
      }
      if (this.Axd != paramObject.Axd)
      {
        AppMethodBeat.o(329957);
        return false;
      }
      if (this.Axe != paramObject.Axe)
      {
        AppMethodBeat.o(329957);
        return false;
      }
      AppMethodBeat.o(329957);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(329953);
      String str = "FinderUserLogOutInfo(logOutFlag=" + this.Axb + ", logOutUrl=" + this.Axc + ", timeStamp=" + this.Axd + ", hasLogOut=" + this.Axe + ')';
      AppMethodBeat.o(329953);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<m, m>
  {
    b(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d.a
 * JD-Core Version:    0.7.0.1
 */