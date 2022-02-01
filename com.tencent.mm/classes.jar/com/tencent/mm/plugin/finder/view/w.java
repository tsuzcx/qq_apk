package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.autogen.mmdata.rpt.un;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.ay.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.protocal.protobuf.fvm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.e;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderWxProfileHelper;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final a GEc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(344330);
    GEc = new a((byte)0);
    TAG = "Finder.FinderWxProfileHelper";
    AppMethodBeat.o(344330);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion;", "", "()V", "TAG", "", "TYPE_COMMENT", "", "TYPE_FANS_LIST", "TYPE_MSG_LIST", "contactToBundle", "", "contact", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "extra", "Landroid/os/Bundle;", "contactToIntent", "intent", "Landroid/content/Intent;", "getCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderContactService$GetContactCallback;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "username", "fromFinderMsg", "", "contactMsgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "addBlackListener", "Lkotlin/Function1;", "intentToContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "report21874", "fromScene", "", "isEnter", "stayTime", "report21875", "saveMsgStrangerContact", "msgUsername", "showWxProfileDialog", "updateDialog", "reqUsername", "contactType", "updateWxProfile", "contentView", "Landroid/view/View;", "updateWxProfileFinderEntry", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d a(Context paramContext, Intent paramIntent, int paramInt, final kotlin.g.a.b<? super String, ah> paramb)
    {
      AppMethodBeat.i(345757);
      s.u(paramContext, "context");
      s.u(paramIntent, "intent");
      long l1 = com.tencent.mm.model.cn.bDw();
      a(paramContext, paramInt, true, 0L);
      paramIntent.putExtra("FromScene_WXPROFILE", paramInt);
      final Bundle localBundle = new Bundle();
      localBundle.putAll(paramIntent.getExtras());
      d locald = new d(paramContext);
      locald.UD(e.f.finder_wx_profile_dialog);
      String str2 = paramIntent.getStringExtra("Username");
      String str1 = paramIntent.getStringExtra("FansId");
      long l2 = paramIntent.getLongExtra("LikeId", 0L);
      int i = paramIntent.getIntExtra("LikeType", 0);
      long l3 = paramIntent.getLongExtra("CommentId", 0L);
      long l4 = localBundle.getLong("FeedId", 0L);
      Object localObject2 = x.a(new avo(), paramIntent.getByteArrayExtra("ContactMsgInfo"));
      Object localObject1 = paramIntent.getStringExtra("V5UserName");
      final boolean bool2 = paramIntent.getBooleanExtra("FromFinderMsg", false);
      boolean bool3 = paramIntent.getBooleanExtra("IsFollowApply", false);
      localBundle.putString("SessionId", ((avo)localObject2).session_id);
      Object localObject3 = locald.rootView.findViewById(e.e.finder_wx_close_btn);
      boolean bool1;
      if ((s.p(str2, com.tencent.mm.model.z.bAM())) || (s.p(localObject1, com.tencent.mm.model.z.bAM())))
      {
        bool1 = true;
        paramIntent.putExtra("IsSelf", bool1);
        localBundle.putBoolean("IsSelf", bool1);
        paramIntent.getBooleanExtra("IsPoster", false);
        ((View)localObject3).setOnClickListener(new w.a..ExternalSyntheticLambda3(locald));
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(locald, localBundle, bool2, paramb));
        locald.dDn();
        locald.GwT = new w.a..ExternalSyntheticLambda9(paramContext, paramInt, l1);
        localObject3 = (CharSequence)str2;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label412;
        }
        paramInt = 1;
        label331:
        if (paramInt == 0) {
          break label422;
        }
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label417;
        }
      }
      label412:
      label417:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label422;
        }
        Log.e(w.access$getTAG$cp(), "[showWxProfileDialog] username " + str2 + ", v5 " + localObject1);
        AppMethodBeat.o(345757);
        return locald;
        bool1 = false;
        break;
        paramInt = 0;
        break label331;
      }
      label422:
      l1 = l3;
      if (l3 == 0L)
      {
        l1 = l3;
        if (l2 != 0L)
        {
          l1 = l3;
          if (i == 1) {
            l1 = l2;
          }
        }
      }
      if ((l1 == 0L) || (l4 == 0L))
      {
        localObject3 = (CharSequence)str1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label699;
        }
        paramInt = 1;
        if (paramInt != 0) {}
      }
      else
      {
        t(((avo)localObject2).ZFM, localBundle);
      }
      if ((l1 != 0L) && (l4 != 0L) && (i != 2))
      {
        paramContext = a(paramContext, locald, str2, bool2, (avo)localObject2, localBundle, paramb);
        ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class)).a(str2, Long.valueOf(l1), Long.valueOf(l4), paramContext);
        label573:
        paramContext = (CharSequence)localObject1;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label879;
        }
        paramInt = 1;
        label594:
        if (paramInt == 0) {
          break label889;
        }
        paramContext = (CharSequence)str2;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label884;
        }
      }
      label699:
      label879:
      label884:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt != 0) || (bool1)) {
          break label889;
        }
        paramContext = new LinkedList();
        paramb = new avo();
        paramb.ZFM = str2;
        localObject1 = ah.aiuX;
        paramContext.add(paramb);
        paramb = com.tencent.mm.plugin.finder.cgi.ay.AAR;
        ay.a.fT((List)paramContext).bFJ().g(new w.a..ExternalSyntheticLambda11(paramIntent, localBundle, locald));
        AppMethodBeat.o(345757);
        return locald;
        paramInt = 0;
        break;
        localObject3 = (CharSequence)str1;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt != 0) && (!bool3)) {
            break label795;
          }
          paramb = a(paramContext, locald, str2, bool2, (avo)localObject2, localBundle, paramb);
          localObject2 = (com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class);
          paramContext = str1;
          if (str1 == null) {
            paramContext = "";
          }
          ((com.tencent.mm.plugin.findersdk.a.y)localObject2).b(str2, paramContext, paramb);
          break;
        }
        if (i == 2)
        {
          paramContext = a(paramContext, locald, str2, bool2, (avo)localObject2, localBundle, paramb);
          ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class)).a(str2, l4, l1, l2, paramContext);
          break label573;
        }
        paramContext = a(paramContext, locald, str2, bool2, (avo)localObject2, localBundle, paramb);
        ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class)).c(str2, paramContext);
        break label573;
        paramInt = 0;
        break label594;
      }
      label795:
      label889:
      paramContext = (Context)localObject1;
      if (bool1) {
        paramContext = com.tencent.mm.model.z.bAM();
      }
      if (bool1) {}
      for (paramInt = 0;; paramInt = 2)
      {
        a(paramContext, localBundle, locald, paramInt);
        break;
      }
    }
    
    private static y.a a(Context paramContext, d paramd, String paramString, boolean paramBoolean, avo paramavo, Bundle paramBundle, kotlin.g.a.b<? super String, ah> paramb)
    {
      AppMethodBeat.i(345771);
      ah.f localf = new ah.f();
      paramContext = new w.a..ExternalSyntheticLambda10(paramString, paramBundle, paramavo, com.tencent.threadpool.h.ahAA.o(new w.a..ExternalSyntheticLambda12(localf, paramContext), 1500L), localf, paramd, paramBoolean, paramb);
      AppMethodBeat.o(345771);
      return paramContext;
    }
    
    private static final ah a(Intent paramIntent, Bundle paramBundle, d paramd, b.a parama)
    {
      AppMethodBeat.i(345944);
      s.u(paramIntent, "$intent");
      s.u(paramBundle, "$extra");
      s.u(paramd, "$dialog");
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        LinkedList localLinkedList = ((ayn)parama.ott).ZIt;
        s.s(localLinkedList, "back.resp.contactList");
        int i;
        if (!((Collection)localLinkedList).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          parama = ((ayn)parama.ott).ZIt;
          s.s(parama, "back.resp.contactList");
          parama = (FinderContact)kotlin.a.p.oL((List)parama);
          if (parama == null)
          {
            AppMethodBeat.o(345944);
            return null;
            i = 0;
          }
          else
          {
            paramIntent.putExtra("V5UserName", parama.wx_username_v5);
            paramBundle.putString("V5UserName", parama.wx_username_v5);
            paramIntent = w.GEc;
            a(parama.wx_username_v5, paramBundle, paramd, 2);
            paramIntent = ah.aiuX;
            AppMethodBeat.o(345944);
            return paramIntent;
          }
        }
      }
      Log.i(w.access$getTAG$cp(), "acquire v5 failed.");
      paramIntent = ah.aiuX;
      AppMethodBeat.o(345944);
      return paramIntent;
    }
    
    private static final void a(Context paramContext, int paramInt, long paramLong)
    {
      AppMethodBeat.i(345936);
      s.u(paramContext, "$context");
      a locala = w.GEc;
      a(paramContext, paramInt, false, com.tencent.mm.model.cn.bDw() - paramLong);
      AppMethodBeat.o(345936);
    }
    
    private static void a(Context paramContext, int paramInt, boolean paramBoolean, long paramLong)
    {
      int j = 0;
      AppMethodBeat.i(345838);
      Object localObject1;
      un localun;
      label58:
      Object localObject2;
      label98:
      label114:
      int i;
      if ((paramContext instanceof MMFinderUI))
      {
        localObject1 = k.aeZF;
        localObject1 = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).fou();
        localun = new un();
        if (localObject1 != null) {
          break label239;
        }
        paramContext = null;
        localObject2 = paramContext;
        if (paramContext == null) {
          localObject2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        }
        localun.Ak((String)localObject2);
        if (localObject1 != null) {
          break label248;
        }
        paramContext = "";
        localun.Al(paramContext);
        if (localObject1 != null) {
          break label270;
        }
        paramContext = "";
        localun.Ap(paramContext);
        if (localObject1 != null) {
          break label292;
        }
        i = 0;
        label129:
        localun.Aq(String.valueOf(i));
        localun.Am("97");
        localun.Ao("{\"scene\":" + paramInt + '}');
        if (!paramBoolean) {
          break label302;
        }
      }
      label270:
      label292:
      label302:
      for (paramInt = j;; paramInt = 1)
      {
        localun.iGK = paramInt;
        localun.An(String.valueOf(com.tencent.mm.model.cn.bDw()));
        localun.iGM = paramLong;
        localun.bMH();
        paramContext = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)localun);
        AppMethodBeat.o(345838);
        return;
        localObject1 = null;
        break;
        label239:
        paramContext = ((bui)localObject1).sessionId;
        break label58;
        label248:
        localObject2 = ((bui)localObject1).zIO;
        paramContext = (Context)localObject2;
        if (localObject2 != null) {
          break label98;
        }
        paramContext = "";
        break label98;
        localObject2 = ((bui)localObject1).zIB;
        paramContext = (Context)localObject2;
        if (localObject2 != null) {
          break label114;
        }
        paramContext = "";
        break label114;
        i = ((bui)localObject1).hLK;
        break label129;
      }
    }
    
    private static final void a(View paramView1, long paramLong, ah.e parame, View paramView2)
    {
      AppMethodBeat.i(345893);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView1);
      localb.hB(paramLong);
      localb.cH(parame);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$contentView");
      s.u(parame, "$commentId");
      paramView2 = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
      paramView1 = paramView1.getContext();
      s.s(paramView1, "contentView.context");
      com.tencent.mm.plugin.finder.feed.logic.a.a(paramView1, paramLong, parame.aixc, 0, 0, 24);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345893);
    }
    
    private static void a(View paramView, Bundle paramBundle)
    {
      AppMethodBeat.i(345733);
      View localView1 = paramView.findViewById(e.e.contact_finder_container);
      View localView2 = paramView.findViewById(e.e.middle_line);
      FinderHalfContactItem localFinderHalfContactItem1 = (FinderHalfContactItem)paramView.findViewById(e.e.contact_finder_entry);
      FinderHalfContactItem localFinderHalfContactItem2 = (FinderHalfContactItem)paramView.findViewById(e.e.contact_recent_like_entry);
      Context localContext = paramView.getContext();
      paramView = localContext.getString(e.h.finder_title);
      s.s(paramView, "context.getString(R.string.finder_title)");
      localFinderHalfContactItem1.setTitle(paramView);
      paramView = localContext.getString(e.h.finder_recent_like_entry);
      s.s(paramView, "context.getString(R.stri…finder_recent_like_entry)");
      localFinderHalfContactItem2.setTitle(paramView);
      localView1.setVisibility(8);
      Object localObject;
      if (paramBundle == null) {
        localObject = "";
      }
      for (;;)
      {
        label122:
        String str;
        label131:
        int i;
        label137:
        int j;
        if (paramBundle == null)
        {
          paramView = "";
          if (paramBundle != null) {
            break label372;
          }
          str = "";
          if (paramBundle != null) {
            break label400;
          }
          i = 0;
          if (((CharSequence)localObject).length() != 0) {
            break label411;
          }
          j = 1;
          if (j != 0) {
            break label664;
          }
          paramBundle = (com.tencent.mm.bx.a)new fvk();
          localObject = e.bFB((String)localObject);
        }
        try
        {
          paramBundle.parseFrom((byte[])localObject);
          localfvk = (fvk)paramBundle;
          if (localfvk != null)
          {
            localView1.setVisibility(0);
            localf = new ah.f();
            localf.aqH = "";
            if (localfvk.contact == null)
            {
              localFinderHalfContactItem1.setVisibility(8);
              if (localfvk.aahj != 1) {
                break label620;
              }
              localFinderHalfContactItem2.setVisibility(0);
              if (localFinderHalfContactItem1.getVisibility() != 0) {
                break label541;
              }
              localFinderHalfContactItem2.a(null);
              localFinderHalfContactItem1.setOnClickListener(new w.a..ExternalSyntheticLambda7(localf, localContext, i));
              localFinderHalfContactItem2.setOnClickListener(new w.a..ExternalSyntheticLambda4(paramView, localContext, str));
              if ((localFinderHalfContactItem1.getVisibility() != 0) || (localFinderHalfContactItem2.getVisibility() != 0)) {
                break label630;
              }
              localView2.setVisibility(0);
              AppMethodBeat.o(345733);
              return;
              paramView = paramBundle.getString("UserPreviewInfo", "");
              localObject = paramView;
              if (paramView != null) {
                continue;
              }
              localObject = "";
              continue;
              paramView = paramBundle.getString("V5UserName", "");
              if (paramView == null)
              {
                paramView = "";
                break label122;
              }
              break label122;
              label372:
              str = paramBundle.getString("Nickname", "");
              if (str == null)
              {
                str = "";
                break label131;
              }
              break label131;
              label400:
              i = paramBundle.getInt("FromScene_WXPROFILE", 0);
              break label137;
              label411:
              j = 0;
            }
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            fvk localfvk;
            ah.f localf;
            Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
            paramBundle = null;
            continue;
            localFinderHalfContactItem1.setVisibility(0);
            if (localfvk.aahh == 0)
            {
              paramBundle = new fvm();
              paramBundle.ZIQ.addAll((Collection)localfvk.ZIQ);
              localObject = ah.aiuX;
              localFinderHalfContactItem1.a(paramBundle);
              label488:
              paramBundle = localfvk.contact;
              if (paramBundle != null) {
                break label520;
              }
              paramBundle = "";
            }
            for (;;)
            {
              localf.aqH = paramBundle;
              break;
              localFinderHalfContactItem1.a(null);
              break label488;
              label520:
              localObject = paramBundle.username;
              paramBundle = (Bundle)localObject;
              if (localObject == null) {
                paramBundle = "";
              }
            }
            label541:
            localObject = new fvm();
            LinkedList localLinkedList = ((fvm)localObject).ZIQ;
            paramBundle = localfvk.aahk;
            if (paramBundle == null)
            {
              paramBundle = null;
              label569:
              if (paramBundle != null) {
                break label612;
              }
            }
            label612:
            for (paramBundle = (Collection)kotlin.a.ab.aivy;; paramBundle = (Collection)paramBundle)
            {
              localLinkedList.addAll(paramBundle);
              paramBundle = ah.aiuX;
              localFinderHalfContactItem2.a((fvm)localObject);
              break;
              paramBundle = paramBundle.ZJE;
              break label569;
            }
            label620:
            localFinderHalfContactItem2.setVisibility(8);
          }
          label630:
          localView2.setVisibility(8);
          if ((localFinderHalfContactItem1.getVisibility() == 8) && (localFinderHalfContactItem2.getVisibility() == 8)) {
            localView1.setVisibility(8);
          }
        }
      }
      label664:
      AppMethodBeat.o(345733);
    }
    
    private static final void a(View paramView1, String paramString, View paramView2)
    {
      AppMethodBeat.i(345850);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView1);
      localb.cH(paramString);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$contentView");
      paramView2 = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramView1 = paramView1.getContext();
      s.s(paramView1, "contentView.context");
      s.s(paramString, "wxUsername");
      com.tencent.mm.plugin.finder.utils.a.aK(paramView1, paramString);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345850);
    }
    
    public static void a(ch paramch, Intent paramIntent)
    {
      AppMethodBeat.i(345809);
      s.u(paramch, "contact");
      s.u(paramIntent, "intent");
      paramIntent.putExtra("Username", paramch.getUsername());
      paramIntent.putExtra("Avatar", paramch.amx());
      paramIntent.putExtra("Nickname", paramch.aSV());
      paramIntent.putExtra("Sex", paramch.dUv());
      paramIntent.putExtra("contactId", paramch.dUu());
      paramIntent.putExtra("Province", paramch.getProvince());
      paramIntent.putExtra("City", paramch.getCity());
      paramIntent.putExtra("Country", paramch.getCountry());
      paramIntent.putExtra("Signature", paramch.getSignature());
      AppMethodBeat.o(345809);
    }
    
    private static final void a(String paramString1, Context paramContext, String paramString2, View paramView)
    {
      AppMethodBeat.i(345924);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramString1);
      localb.cH(paramContext);
      localb.cH(paramString2);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramString1, "$username");
      s.u(paramString2, "$nickText");
      if (!Util.isNullOrNil(paramString1)) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().e(paramContext, paramString1, paramString2, 98);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345924);
    }
    
    private static void a(String paramString, Bundle paramBundle, final d paramd, int paramInt)
    {
      AppMethodBeat.i(345783);
      com.tencent.mm.plugin.finder.utils.ay localay = com.tencent.mm.plugin.finder.utils.ay.Gjp;
      com.tencent.mm.plugin.finder.utils.ay.a(paramString, null, (ca.a)new d(paramBundle, paramd), null, true, paramInt);
      AppMethodBeat.o(345783);
    }
    
    private static final void a(String paramString, final Bundle paramBundle, avo paramavo, com.tencent.threadpool.i.d paramd, final ah.f paramf, final d paramd1, final boolean paramBoolean, final kotlin.g.a.b paramb, ch paramch)
    {
      AppMethodBeat.i(345977);
      s.u(paramBundle, "$extra");
      s.u(paramavo, "$contactMsgInfo");
      s.u(paramf, "$loadingDialog");
      s.u(paramd1, "$dialog");
      if (s.p(paramString, paramch.getUsername()))
      {
        Log.i(w.access$getTAG$cp(), "get contact success %s", new Object[] { paramString });
        paramString = w.GEc;
        s.s(paramch, "newContact");
        s.u(paramch, "contact");
        s.u(paramBundle, "extra");
        paramBundle.putString("Avatar", paramch.amx());
        paramBundle.putString("Nickname", paramch.aSV());
        paramBundle.putInt("Sex", paramch.dUv());
        paramBundle.putLong("contactId", paramch.dUu());
        paramBundle.putString("Province", paramch.getProvince());
        paramBundle.putString("City", paramch.getCity());
        paramBundle.putString("Country", paramch.getCountry());
        paramBundle.putString("Signature", paramch.getSignature());
        paramString = w.GEc;
        t(paramavo.ZFM, paramBundle);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramd, paramf, paramd1, paramBundle, paramBoolean, paramb));
        AppMethodBeat.o(345977);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd, paramf, paramd1, paramBundle, paramBoolean, paramb));
      AppMethodBeat.o(345977);
    }
    
    private static final void a(String paramString1, boolean paramBoolean1, View paramView1, String paramString2, String paramString3, long paramLong, ah.e parame, boolean paramBoolean2, bui parambui, boolean paramBoolean3, View paramView2)
    {
      AppMethodBeat.i(345862);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramString1);
      localb.fv(paramBoolean1);
      localb.cH(paramView1);
      localb.cH(paramString2);
      localb.cH(paramString3);
      localb.hB(paramLong);
      localb.cH(parame);
      localb.fv(paramBoolean2);
      localb.cH(parambui);
      localb.fv(paramBoolean3);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$contentView");
      s.u(parame, "$commentId");
      paramView2 = (CharSequence)paramString1;
      int i;
      if ((paramView2 == null) || (paramView2.length() == 0))
      {
        i = 1;
        if ((i == 0) || (paramBoolean1)) {
          break label277;
        }
        paramString1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        paramString1 = paramView1.getContext();
        s.s(paramString1, "contentView.context");
        s.s(paramString2, "sessionId");
        s.s(paramString3, "username");
        com.tencent.mm.plugin.finder.utils.a.a(paramString1, paramString2, paramString3, paramLong, parame.aixc, paramBoolean2, parambui);
      }
      for (;;)
      {
        if (paramBoolean3)
        {
          paramString1 = com.tencent.mm.plugin.finder.utils.y.GgX;
          paramString1 = paramView1.getContext();
          s.s(paramString1, "contentView.context");
          com.tencent.mm.plugin.finder.utils.y.aC(paramString1, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(345862);
        return;
        i = 0;
        break;
        label277:
        if (paramBoolean1)
        {
          paramString1 = com.tencent.mm.plugin.finder.utils.a.GfO;
          paramString1 = paramView1.getContext();
          s.s(paramString1, "contentView.context");
          s.s(paramString2, "sessionId");
          s.s(paramString3, "username");
          com.tencent.mm.plugin.finder.utils.a.b(paramString1, paramString2, paramString3, parambui);
        }
        else
        {
          paramString3 = com.tencent.mm.plugin.finder.utils.a.GfO;
          paramString3 = paramView1.getContext();
          s.s(paramString3, "contentView.context");
          s.s(paramString2, "sessionId");
          s.s(paramString1, "fansId");
          com.tencent.mm.plugin.finder.utils.a.a(paramString3, paramString2, paramString1, parambui);
        }
      }
    }
    
    private static final void a(kotlin.g.a.b paramb, View paramView1, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, ah.e parame, long paramLong, String paramString3, TextView paramTextView, View paramView2)
    {
      AppMethodBeat.i(345881);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView1);
      localb.cH(paramString1);
      localb.fv(paramBoolean1);
      localb.fv(paramBoolean2);
      localb.fv(paramBoolean3);
      localb.cH(paramString2);
      localb.cH(parame);
      localb.hB(paramLong);
      localb.cH(paramString3);
      localb.cH(paramTextView);
      localb.cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramView1, "$contentView");
      s.u(parame, "$commentId");
      if (paramb != null)
      {
        paramb.invoke(paramString1);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(345881);
        return;
      }
      paramb = null;
      if ((paramView1.getContext() instanceof ck))
      {
        try
        {
          paramb = paramView1.getContext();
          if (paramb != null) {
            break label334;
          }
          paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.findersdk.api.IModifyUserResult<com.tencent.mm.protocal.protobuf.FinderModBlackList>");
          AppMethodBeat.o(345881);
          throw paramb;
        }
        catch (ClassCastException paramb)
        {
          paramb = null;
        }
      }
      else
      {
        if (Util.isNullOrNil(paramString1)) {
          break label350;
        }
        if (!paramBoolean1) {
          break label342;
        }
        paramLong = 14L;
        label241:
        paramString2 = (com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class);
        paramString1 = Util.nullAsNil(paramString1);
        s.s(paramString1, "nullAsNil(fansId)");
        paramString2.b(paramString1, true, paramb);
        paramb = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramb = paramView1.getContext();
        s.s(paramb, "contentView.context");
        com.tencent.mm.plugin.finder.report.z.b(paramb, paramLong, 4L);
      }
      for (;;)
      {
        paramTextView.setVisibility(4);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(345881);
        return;
        label334:
        paramb = (ck)paramb;
        break;
        label342:
        paramLong = 8L;
        break label241;
        label350:
        if ((!paramBoolean2) && (!paramBoolean3)) {
          break label416;
        }
        paramString1 = (com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class);
        s.s(paramString2, "username");
        paramString1.b(paramString2, paramb);
        paramb = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramb = paramView1.getContext();
        s.s(paramb, "contentView.context");
        com.tencent.mm.plugin.finder.report.z.b(paramb, 14L, 4L);
      }
      label416:
      if (paramBoolean1) {}
      for (long l1 = 14L;; l1 = 11L)
      {
        paramString1 = (com.tencent.mm.plugin.finder.service.p)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.p.class);
        long l2 = parame.aixc;
        s.s(paramString3, "nonceId");
        paramString1.a(l2, paramLong, paramString3, paramb);
        paramb = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramb = paramView1.getContext();
        s.s(paramb, "contentView.context");
        com.tencent.mm.plugin.finder.report.z.b(paramb, l1, 4L);
        break;
      }
    }
    
    private static final void a(ah.f paramf, Context paramContext)
    {
      AppMethodBeat.i(345959);
      s.u(paramf, "$loadingDialog");
      s.u(paramContext, "$context");
      paramf.aqH = com.tencent.mm.ui.base.w.a(paramContext, (CharSequence)paramContext.getResources().getString(e.h.app_waiting), true, 0, w.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(345959);
    }
    
    private static final void a(ah.f paramf, Context paramContext, int paramInt, View paramView)
    {
      AppMethodBeat.i(345914);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramf);
      localb.cH(paramContext);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramf, "$finderUsername");
      boolean bool;
      if (!Util.isNullOrNil((String)paramf.aqH))
      {
        paramView = new Intent();
        paramView.putExtra("finder_username", (String)paramf.aqH);
        paramView.putExtra("key_enter_profile_type", 14);
        paramView.putExtra("KEY_REF_COMMENTSCENE", 97);
        bool = s.p(paramf.aqH, com.tencent.mm.model.z.bAW());
        paramf = (com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
        if (!bool) {
          break label322;
        }
      }
      label322:
      for (int i = 33;; i = 32)
      {
        paramf.fillContextIdToIntent(14, 2, i, paramView);
        paramView.putExtra("KEY_FINDER_SELF_FLAG", bool);
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI(paramContext, paramView);
        paramf = w.GEc;
        paramf = new gk();
        paramf.qU(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
        paramf.qW("97");
        paramf.qZ("{\"scene\":" + paramInt + '}');
        paramf.qY("fans_list_to_profile");
        paramf.bMH();
        paramContext = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((com.tencent.mm.plugin.report.a)paramf);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(345914);
        return;
      }
    }
    
    private static m au(Bundle paramBundle)
    {
      AppMethodBeat.i(345819);
      m localm = new m();
      String str = paramBundle.getString("Username", "");
      s.s(str, "extra.getString(Constant…erWxProfile.Username, \"\")");
      localm.setUsername(str);
      str = paramBundle.getString("Nickname", "");
      s.s(str, "extra.getString(Constant…erWxProfile.Nickname, \"\")");
      localm.setNickname(str);
      localm.pv(paramBundle.getInt("Sex", 0));
      str = paramBundle.getString("Signature", "");
      s.s(str, "extra.getString(Constant…rWxProfile.Signature, \"\")");
      localm.Bo(str);
      str = paramBundle.getString("Province", "");
      s.s(str, "extra.getString(Constant…erWxProfile.Province, \"\")");
      localm.Bp(str);
      str = paramBundle.getString("City", "");
      s.s(str, "extra.getString(Constant…FinderWxProfile.City, \"\")");
      localm.Bq(str);
      str = paramBundle.getString("Avatar", "");
      s.s(str, "extra.getString(Constant…nderWxProfile.Avatar, \"\")");
      localm.auZ(str);
      paramBundle = paramBundle.getString("Country", "");
      s.s(paramBundle, "extra.getString(Constant…derWxProfile.Country, \"\")");
      localm.ava(paramBundle);
      AppMethodBeat.o(345819);
      return localm;
    }
    
    private static final void gZ(View paramView)
    {
      AppMethodBeat.i(345902);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345902);
    }
    
    private static final void m(d paramd, View paramView)
    {
      AppMethodBeat.i(345930);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramd);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramd, "$dialog");
      paramd.cyW();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(345930);
    }
    
    private static void t(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(345797);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(w.access$getTAG$cp(), "[saveMsgStrangerContact] msgUsername is null");
        AppMethodBeat.o(345797);
        return;
      }
      paramBundle = au(paramBundle);
      paramBundle.setUsername(paramString);
      if (((CharSequence)paramBundle.amx()).length() == 0)
      {
        i = 1;
        if (i != 0) {
          Log.w(w.access$getTAG$cp(), "nickname=" + paramBundle.getNickname() + " avatarUrl is null. username=" + paramBundle.getUsername());
        }
        paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgStrangerContactStorage();
        if (i != 0) {
          break label162;
        }
      }
      label162:
      for (boolean bool = true;; bool = false)
      {
        paramString.b(paramBundle, bool);
        AppMethodBeat.o(345797);
        return;
        i = 0;
        break;
      }
    }
    
    private static final void v(DialogInterface paramDialogInterface) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(com.tencent.threadpool.i.d<?> paramd, ah.f<com.tencent.mm.ui.base.w> paramf, d paramd1, Bundle paramBundle, boolean paramBoolean, kotlin.g.a.b<? super String, ah> paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(com.tencent.threadpool.i.d<?> paramd, ah.f<com.tencent.mm.ui.base.w> paramf, d paramd1, Bundle paramBundle, boolean paramBoolean, kotlin.g.a.b<? super String, ah> paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(d paramd, Bundle paramBundle, boolean paramBoolean, kotlin.g.a.b<? super String, ah> paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/FinderWxProfileHelper$Companion$updateDialog$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements ca.a<Object>
    {
      d(Bundle paramBundle, d paramd) {}
      
      public final void onCallback(Object paramObject)
      {
        AppMethodBeat.i(345117);
        s.u(paramObject, "ret");
        if ((paramObject instanceof fvk))
        {
          this.GEg.putString("UserPreviewInfo", e.aC(((fvk)paramObject).toByteArray()));
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramd, this.GEg));
        }
        AppMethodBeat.o(345117);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(d paramd, Bundle paramBundle)
        {
          super();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.w
 * JD-Core Version:    0.7.0.1
 */