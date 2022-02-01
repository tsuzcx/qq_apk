package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final a tso;
  public static final a tsp;
  
  static
  {
    AppMethodBeat.i(165145);
    tsp = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    tso = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(165145);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "checkContactCacheAvailable", "username", "deleteCache", "", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getSelf", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "isPrivate", "isWaiting", "operationSetFollow", "finderUserName", "followFlag", "", "operationSetIsNeedShowUnFollow", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "plugin-finder_release"})
  public static final class a
  {
    public static boolean a(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(165140);
      p.h(paramFinderContact, "fcontact");
      Object localObject = (CharSequence)paramFinderContact.username;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(c.access$getTAG$cp(), "error FinderContact username is null " + Util.getStack());
        AppMethodBeat.o(165140);
        return false;
      }
      String str = paramFinderContact.username;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramFinderContact = b.a(paramFinderContact, asG((String)localObject));
      c.access$getDEBUG$cp();
      Log.i(c.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { paramFinderContact.getUsername(), paramFinderContact.cXK() });
      e(paramFinderContact);
      b(paramFinderContact);
      AppMethodBeat.o(165140);
      return true;
    }
    
    private static boolean asF(String paramString)
    {
      AppMethodBeat.i(242184);
      Object localObject = c.cXE().asE(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((g)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label61;
        }
      }
      label61:
      for (int i = 1; (i != 0) || (p.j(paramString, z.aUg())); i = 0)
      {
        AppMethodBeat.o(242184);
        return false;
      }
      AppMethodBeat.o(242184);
      return true;
    }
    
    public static g asG(String paramString)
    {
      AppMethodBeat.i(165132);
      if (paramString == null)
      {
        AppMethodBeat.o(165132);
        return null;
      }
      if (p.j(paramString, z.aUg()))
      {
        paramString = cXF();
        AppMethodBeat.o(165132);
        return paramString;
      }
      if (asF(paramString))
      {
        paramString = c.cXE().asE(paramString);
        AppMethodBeat.o(165132);
        return paramString;
      }
      g localg = asH(paramString);
      if (localg != null) {
        e(localg);
      }
      paramString = c.cXE().asE(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static g asH(String paramString)
    {
      AppMethodBeat.i(165133);
      g localg = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage().asG(paramString);
      String str2 = c.access$getTAG$cp();
      if (localg != null) {}
      for (String str1 = localg.cXK();; str1 = null)
      {
        Log.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return localg;
      }
    }
    
    public static boolean asI(String paramString)
    {
      AppMethodBeat.i(165134);
      Log.d(c.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if ((paramString == null) || (Util.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((c.cXE().asE(paramString) != null) || (asH(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean asJ(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = c.tsp;
        paramString = asG(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.tsD;
          if (i == g.cXO())
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
    
    public static boolean asK(String paramString)
    {
      AppMethodBeat.i(242187);
      if (paramString != null)
      {
        a locala = c.tsp;
        paramString = asG(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.tsD;
          if (i == g.cXN())
          {
            AppMethodBeat.o(242187);
            return true;
          }
        }
        AppMethodBeat.o(242187);
        return false;
      }
      AppMethodBeat.o(242187);
      return false;
    }
    
    private static boolean b(g paramg)
    {
      boolean bool = false;
      AppMethodBeat.i(165135);
      Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getContactStorage();
      p.h(paramg, "ct");
      paramg.field_updateTime = cl.aWA();
      Object localObject2;
      int i;
      StringBuilder localStringBuilder;
      if (((d)localObject1).asG(paramg.getUsername()) == null)
      {
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        i = (int)((d)localObject1).vDi.insert("FinderContact", "", (ContentValues)localObject2);
        Log.i("Finder.FinderContactStorage", "insert contact " + paramg + ' ' + i);
        if (i > 0) {
          bool = true;
        }
        if (bool) {
          ((d)localObject1).doNotify("FinderContact", 4, paramg.getUsername());
        }
        localObject2 = c.access$getTAG$cp();
        localStringBuilder = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramg.getUsername()).append(' ').append(paramg.cXK()).append(' ');
        if (!c.access$getDEBUG$cp()) {
          break label353;
        }
      }
      label353:
      for (localObject1 = Util.getStack();; localObject1 = "")
      {
        Log.i((String)localObject2, localObject1);
        if (bool)
        {
          localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().d(g.f(paramg), true);
        }
        AppMethodBeat.o(165135);
        return bool;
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        i = ((d)localObject1).vDi.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { paramg.field_username });
        Log.i("Finder.FinderContactStorage", "updateContact " + paramg.cXL() + ' ' + i);
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
        Log.e(c.access$getTAG$cp(), "error FinderContact username is null " + Util.getStack());
        AppMethodBeat.o(165141);
        return false;
      }
      Object localObject2 = paramFinderContact.username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = asG((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new g();
      }
      Object localObject4 = paramFinderContact.username;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((g)localObject1).setUsername((String)localObject2);
      localObject4 = paramFinderContact.headUrl;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((g)localObject1).asL((String)localObject2);
      localObject4 = paramFinderContact.nickname;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((g)localObject1).setNickname((String)localObject2);
      localObject4 = ((g)localObject1).field_authInfo;
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
          ((g)localObject1).field_extInfo = paramFinderContact.extInfo;
          if (!c.access$getDEBUG$cp()) {
            break label663;
          }
          localObject4 = c.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("replaceMinContact fcontact : ");
          p.h(paramFinderContact, "$this$info");
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
          localObject2 = Long.valueOf(((apr)localObject2).LBA);
          label526:
          localObject2 = ((StringBuilder)localObject5).append(localObject2).append(", liveSwitchFlag:");
          localObject5 = paramFinderContact.live_info;
          paramFinderContact = localObject3;
          if (localObject5 != null) {
            paramFinderContact = Integer.valueOf(((apr)localObject5).LBB);
          }
          Log.i((String)localObject4, ((StringBuilder)localObject2).append(paramFinderContact).toString() + "  from " + Util.getStack());
        }
      }
      for (;;)
      {
        e((g)localObject1);
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
        ((g)localObject1).field_authInfo = paramFinderContact.authInfo;
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
        Log.i(c.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((g)localObject1).cXL() });
      }
    }
    
    public static boolean c(g paramg)
    {
      AppMethodBeat.i(165136);
      p.h(paramg, "contact");
      String str = c.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramg.getUsername()).append(' ').append(paramg.cXK()).append(' ');
      if (c.access$getDEBUG$cp()) {}
      for (Object localObject = Util.getStack();; localObject = "")
      {
        Log.i(str, localObject);
        if (!asI(paramg.getUsername())) {
          break;
        }
        e(paramg);
        if (asH(paramg.getUsername()) != null)
        {
          localObject = c.tsp;
          b(paramg);
        }
        AppMethodBeat.o(165136);
        return true;
      }
      AppMethodBeat.o(165136);
      return false;
    }
    
    public static g cXF()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = c.cXE();
      Object localObject2 = z.aUg();
      p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((a)localObject1).asE((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new g();
        ((g)localObject1).field_username = z.aUg();
      }
      for (;;)
      {
        localObject2 = g.tsD;
        ((g)localObject1).field_follow_Flag = g.cXO();
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((e)localObject2).azQ().get(ar.a.OjH, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_nickname = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((e)localObject2).azQ().get(ar.a.OjJ, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((e)localObject2).azQ().get(ar.a.OjL, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((e)localObject2).azQ().get(ar.a.OjI, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_signature = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_originalFlag = ((e)localObject2).azQ().getInt(ar.a.OjP, 0);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_originalEntranceFlag = ((e)localObject2).azQ().getInt(ar.a.OjU, 0);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_extFlag = ((e)localObject2).azQ().getInt(ar.a.Okw, 0);
        localObject2 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((e)localObject2).azQ().get(ar.a.OjK, "");
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (String)localObject2;
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((g)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (com.tencent.mm.bw.a)((g)localObject1).field_authInfo;
          localObject3 = Util.decodeHexString((String)localObject3);
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
            localObject2 = com.tencent.mm.kernel.g.aAh();
            p.g(localObject2, "MMKernel.storage()");
            localObject2 = ((e)localObject2).azQ().get(ar.a.Okk, "");
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
          ((g)localObject1).field_authInfo = null;
        }
        ((g)localObject1).field_liveCoverImg = ((String)localException);
        e locale = com.tencent.mm.kernel.g.aAh();
        p.g(locale, "MMKernel.storage()");
        ((g)localObject1).field_liveAnchorStatusFlag = locale.azQ().a(ar.a.Okl, 0L);
        locale = com.tencent.mm.kernel.g.aAh();
        p.g(locale, "MMKernel.storage()");
        ((g)localObject1).field_liveSwitchFlag = locale.azQ().a(ar.a.Okm, 0L);
        AppMethodBeat.o(165131);
        return localObject1;
      }
    }
    
    public static boolean d(g paramg)
    {
      AppMethodBeat.i(242186);
      p.h(paramg, "contact");
      e(paramg);
      boolean bool = b(paramg);
      AppMethodBeat.o(242186);
      return bool;
    }
    
    public static void du(String paramString, int paramInt)
    {
      AppMethodBeat.i(242185);
      p.h(paramString, "finderUserName");
      Object localObject2 = c.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramInt).append(" and cacheItem ");
      Object localObject1 = c.cXE().asE(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((g)localObject1).cXK();; localObject1 = null)
      {
        Log.i((String)localObject2, (String)localObject1);
        localObject3 = (kotlin.g.a.b)new a(paramInt);
        localObject2 = asG(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new g();
          ((g)localObject1).field_username = paramString;
        }
        paramString = (g)((kotlin.g.a.b)localObject3).invoke(localObject1);
        e(paramString);
        b(paramString);
        AppMethodBeat.o(242185);
        return;
      }
    }
    
    public static void e(g paramg)
    {
      AppMethodBeat.i(165142);
      String str1 = paramg.getUsername();
      c.cXE().a(str1, paramg);
      paramg = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramg, "MMKernel.service(IMessengerStorage::class.java)");
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramg).aSN();
      String str2 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage().avA(str1);
      paramg.ayf(str1);
      paramg.ayf(str2);
      AppMethodBeat.o(165142);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<g, g>
    {
      a(int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */