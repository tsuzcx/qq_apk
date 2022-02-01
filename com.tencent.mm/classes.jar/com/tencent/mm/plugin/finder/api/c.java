package com.tencent.mm.plugin.finder.api;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import d.g.b.p;
import d.g.b.q;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static boolean DEBUG = false;
  private static final String TAG = "Finder.FinderContactLogic";
  private static final a rPx;
  public static final a rPy;
  
  static
  {
    AppMethodBeat.i(165145);
    rPy = new a((byte)0);
    TAG = "Finder.FinderContactLogic";
    rPx = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(165145);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "TAG", "", "TAG_FINDER_CONTACT", "cacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "checkContactCacheAvailable", "username", "deleteCache", "", "deleteContact", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getContactFromDB", "getSelf", "hardCodeSelf", "isContactExists", "isFinderContactUser", "isFollow", "isNeedShowUnFollow", "isPrivate", "isWaiting", "operationSetFollow", "finderUserName", "followFlag", "", "operationSetIsNeedShowUnFollow", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "replaceContact", "contact", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "operation", "ct", "onlyMemory", "replaceContactInDB", "replaceMinContact", "selectFollowedContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "limit", "updateCache", "updateContact", "plugin-finder_release"})
  public static final class a
  {
    private static boolean a(g paramg)
    {
      boolean bool = false;
      AppMethodBeat.i(165135);
      Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage();
      p.h(paramg, "ct");
      paramg.field_updateTime = ch.aDc();
      Object localObject2;
      int i;
      StringBuilder localStringBuilder;
      if (((com.tencent.mm.plugin.finder.storage.c)localObject1).ahT(paramg.getUsername()) == null)
      {
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        i = (int)((com.tencent.mm.plugin.finder.storage.c)localObject1).sIs.insert("FinderContact", "", (ContentValues)localObject2);
        ae.i("Finder.FinderContactStorage", "insert contact " + paramg + ' ' + i);
        if (i > 0) {
          bool = true;
        }
        if (bool) {
          ((com.tencent.mm.plugin.finder.storage.c)localObject1).doNotify("FinderContact", 4, paramg.getUsername());
        }
        localObject2 = c.access$getTAG$cp();
        localStringBuilder = new StringBuilder("replaceContact success=").append(bool).append(' ').append(paramg.getUsername()).append(' ').append(paramg.czp()).append(' ');
        if (!c.access$getDEBUG$cp()) {
          break label339;
        }
      }
      label339:
      for (localObject1 = bu.fpN();; localObject1 = "")
      {
        ae.i((String)localObject2, localObject1);
        if (bool)
        {
          localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azF().d(g.e(paramg), true);
        }
        AppMethodBeat.o(165135);
        return bool;
        p.h(paramg, "contact");
        localObject2 = paramg.convertTo();
        ((ContentValues)localObject2).remove("rowid");
        i = ((com.tencent.mm.plugin.finder.storage.c)localObject1).sIs.update("FinderContact", (ContentValues)localObject2, "username=?", new String[] { paramg.field_username });
        ae.i("Finder.FinderContactStorage", "updateContact " + paramg.czq() + ' ' + i);
        if (i <= 0) {
          break;
        }
        bool = true;
        break;
      }
    }
    
    public static boolean a(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(165140);
      p.h(paramFinderContact, "fcontact");
      Object localObject = (CharSequence)paramFinderContact.username;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ae.e(c.access$getTAG$cp(), "error FinderContact username is null " + bu.fpN());
        AppMethodBeat.o(165140);
        return false;
      }
      String str = paramFinderContact.username;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramFinderContact = b.a(paramFinderContact, ahT((String)localObject));
      c.access$getDEBUG$cp();
      ae.i(c.access$getTAG$cp(), "replaceContact contact %s result %s", new Object[] { paramFinderContact.getUsername(), paramFinderContact.czp() });
      d(paramFinderContact);
      a(paramFinderContact);
      AppMethodBeat.o(165140);
      return true;
    }
    
    public static g ahT(String paramString)
    {
      AppMethodBeat.i(165132);
      if (paramString == null)
      {
        AppMethodBeat.o(165132);
        return null;
      }
      if (p.i(paramString, com.tencent.mm.model.v.aAK()))
      {
        paramString = czk();
        AppMethodBeat.o(165132);
        return paramString;
      }
      Object localObject = c.czj().ahS(paramString);
      if (localObject != null)
      {
        localObject = (CharSequence)((g)localObject).field_username;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label111;
        }
        i = 1;
        if ((i == 0) && (!p.i(paramString, com.tencent.mm.model.v.aAK()))) {
          break label116;
        }
      }
      label111:
      label116:
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label121;
        }
        paramString = c.czj().ahS(paramString);
        AppMethodBeat.o(165132);
        return paramString;
        i = 0;
        break;
      }
      label121:
      localObject = ahU(paramString);
      if (localObject != null) {
        d((g)localObject);
      }
      paramString = c.czj().ahS(paramString);
      AppMethodBeat.o(165132);
      return paramString;
    }
    
    private static g ahU(String paramString)
    {
      AppMethodBeat.i(165133);
      g localg = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getContactStorage().ahT(paramString);
      String str2 = c.access$getTAG$cp();
      if (localg != null) {}
      for (String str1 = localg.czp();; str1 = null)
      {
        ae.i(str2, "get contact %s %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(165133);
        return localg;
      }
    }
    
    public static boolean ahV(String paramString)
    {
      AppMethodBeat.i(165134);
      ae.d(c.access$getTAG$cp(), "isContact  %s exists ?", new Object[] { paramString });
      if ((paramString == null) || (bu.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(165134);
        return false;
      }
      if ((c.czj().ahS(paramString) != null) || (ahU(paramString) != null))
      {
        AppMethodBeat.o(165134);
        return true;
      }
      AppMethodBeat.o(165134);
      return false;
    }
    
    public static boolean ahW(String paramString)
    {
      AppMethodBeat.i(165143);
      if (paramString != null)
      {
        a locala = c.rPy;
        paramString = ahT(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.rPM;
          if (i == g.czt())
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
    
    public static boolean ahX(String paramString)
    {
      AppMethodBeat.i(201426);
      if (paramString != null)
      {
        a locala = c.rPy;
        paramString = ahT(paramString);
        if (paramString != null)
        {
          int i = paramString.field_follow_Flag;
          paramString = g.rPM;
          if (i == g.czs())
          {
            AppMethodBeat.o(201426);
            return true;
          }
        }
        AppMethodBeat.o(201426);
        return false;
      }
      AppMethodBeat.o(201426);
      return false;
    }
    
    public static boolean b(g paramg)
    {
      AppMethodBeat.i(165136);
      p.h(paramg, "contact");
      String str = c.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("update contact ").append(paramg.getUsername()).append(' ').append(paramg.czp()).append(' ');
      if (c.access$getDEBUG$cp()) {}
      for (Object localObject = bu.fpN();; localObject = "")
      {
        ae.i(str, localObject);
        if (!ahV(paramg.getUsername())) {
          break;
        }
        d(paramg);
        if (ahU(paramg.getUsername()) != null)
        {
          localObject = c.rPy;
          a(paramg);
        }
        AppMethodBeat.o(165136);
        return true;
      }
      AppMethodBeat.o(165136);
      return false;
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
        ae.e(c.access$getTAG$cp(), "error FinderContact username is null " + bu.fpN());
        AppMethodBeat.o(165141);
        return false;
      }
      Object localObject2 = paramFinderContact.username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = ahT((String)localObject1);
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
      ((g)localObject1).ahY((String)localObject2);
      localObject4 = paramFinderContact.nickname;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      ((g)localObject1).to((String)localObject2);
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
              break label540;
            }
            localObject2 = ((FinderAuthInfo)localObject2).authProfession;
            label237:
            ((FinderAuthInfo)localObject4).authProfession = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label545;
            }
            i = ((FinderAuthInfo)localObject2).authIconType;
            label257:
            ((FinderAuthInfo)localObject4).authIconType = i;
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label550;
            }
            localObject2 = ((FinderAuthInfo)localObject2).detailLink;
            label277:
            ((FinderAuthInfo)localObject4).detailLink = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label555;
            }
            localObject2 = ((FinderAuthInfo)localObject2).realName;
            label297:
            ((FinderAuthInfo)localObject4).realName = ((String)localObject2);
            localObject2 = paramFinderContact.authInfo;
            if (localObject2 == null) {
              break label560;
            }
            localObject2 = ((FinderAuthInfo)localObject2).authIconUrl;
            label317:
            ((FinderAuthInfo)localObject4).authIconUrl = ((String)localObject2);
          }
        }
        else
        {
          label323:
          ((g)localObject1).field_extInfo = paramFinderContact.extInfo;
          if (!c.access$getDEBUG$cp()) {
            break label581;
          }
          localObject4 = c.access$getTAG$cp();
          StringBuilder localStringBuilder1 = new StringBuilder("replaceMinContact fcontact : ");
          p.h(paramFinderContact, "$this$info");
          StringBuilder localStringBuilder2 = new StringBuilder("info:userName:").append(paramFinderContact.username).append(" nickname: ").append(paramFinderContact.nickname).append(" followFlag: ").append(paramFinderContact.followFlag).append(" auth: ");
          localObject2 = paramFinderContact.authInfo;
          if (localObject2 == null) {
            break label576;
          }
          localObject2 = ((FinderAuthInfo)localObject2).realName;
          label426:
          localStringBuilder2 = localStringBuilder2.append((String)localObject2).append(" signature: ").append(paramFinderContact.signature).append(" headUrl_len: ");
          String str = paramFinderContact.headUrl;
          localObject2 = localObject3;
          if (str != null) {
            localObject2 = Integer.valueOf(str.length());
          }
          ae.i((String)localObject4, localStringBuilder2.append(localObject2).append(", originalFlag:").append(paramFinderContact.originalFlag).toString() + "  from " + bu.fpN());
        }
      }
      for (;;)
      {
        d((g)localObject1);
        AppMethodBeat.o(165141);
        return true;
        localObject2 = null;
        break;
        label540:
        localObject2 = null;
        break label237;
        label545:
        i = 0;
        break label257;
        label550:
        localObject2 = null;
        break label277;
        label555:
        localObject2 = null;
        break label297;
        label560:
        localObject2 = null;
        break label317;
        ((g)localObject1).field_authInfo = paramFinderContact.authInfo;
        break label323;
        label576:
        localObject2 = null;
        break label426;
        label581:
        ae.i(c.access$getTAG$cp(), "replaceMinContact result %s onlyMemory true", new Object[] { ((g)localObject1).czq() });
      }
    }
    
    public static boolean c(g paramg)
    {
      AppMethodBeat.i(201425);
      p.h(paramg, "contact");
      d(paramg);
      boolean bool = a(paramg);
      AppMethodBeat.o(201425);
      return bool;
    }
    
    public static g czk()
    {
      AppMethodBeat.i(165131);
      Object localObject1 = c.czj();
      Object localObject2 = com.tencent.mm.model.v.aAK();
      p.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
      localObject1 = ((a)localObject1).ahS((String)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new g();
        ((g)localObject1).field_username = com.tencent.mm.model.v.aAK();
      }
      for (;;)
      {
        localObject2 = g.rPM;
        ((g)localObject1).field_follow_Flag = g.czt();
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.JaX, "");
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_nickname = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.JaZ, "");
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_avatarUrl = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.Jbb, "");
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_coverImg = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.JaY, "");
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        ((g)localObject1).field_signature = ((String)localObject2);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_originalFlag = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jbe, 0);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_originalEntranceFlag = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jbj, 0);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        ((g)localObject1).field_extFlag = ((com.tencent.mm.kernel.e)localObject2).ajA().getInt(am.a.Jbx, 0);
        localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.Jba, "");
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165131);
          throw ((Throwable)localObject1);
        }
        Object localObject3 = (String)localObject2;
        if (!bu.isNullOrNil((String)localObject3))
        {
          ((g)localObject1).field_authInfo = new FinderAuthInfo();
          localObject2 = (com.tencent.mm.bw.a)((g)localObject1).field_authInfo;
          localObject3 = bu.aSx((String)localObject3);
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject3);
            AppMethodBeat.o(165131);
            return localObject1;
          }
          catch (Exception localException)
          {
            ae.l("safeParser", "", new Object[] { localException });
            continue;
          }
          ((g)localObject1).field_authInfo = null;
        }
      }
    }
    
    public static void d(g paramg)
    {
      AppMethodBeat.i(165142);
      String str1 = paramg.getUsername();
      c.czj().a(str1, paramg);
      paramg = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramg, "MMKernel.service(IMessengerStorage::class.java)");
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramg).azF();
      String str2 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage().aju(str1);
      paramg.alb(str1);
      paramg.alb(str2);
      AppMethodBeat.o(165142);
    }
    
    public static void dn(String paramString, int paramInt)
    {
      AppMethodBeat.i(201424);
      p.h(paramString, "finderUserName");
      Object localObject2 = c.access$getTAG$cp();
      Object localObject3 = new StringBuilder("operationSetFollow ").append(paramString).append(' ').append(paramInt).append(" and cacheItem ");
      Object localObject1 = c.czj().ahS(paramString);
      if (localObject1 != null) {}
      for (localObject1 = ((g)localObject1).czp();; localObject1 = null)
      {
        ae.i((String)localObject2, (String)localObject1);
        localObject3 = (d.g.a.b)new a(paramInt);
        localObject2 = ahT(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new g();
          ((g)localObject1).field_username = paramString;
        }
        paramString = (g)((d.g.a.b)localObject3).invoke(localObject1);
        d(paramString);
        a(paramString);
        AppMethodBeat.o(201424);
        return;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<g, g>
    {
      a(int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.c
 * JD-Core Version:    0.7.0.1
 */