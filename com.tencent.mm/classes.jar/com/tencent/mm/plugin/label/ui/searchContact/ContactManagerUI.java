package com.tencent.mm.plugin.label.ui.searchContact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.kb;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "()V", "COMMIT_MAX_NUM_EVERYTIME", "", "getCOMMIT_MAX_NUM_EVERYTIME", "()I", "dataSource", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataSource;", "dataSource$delegate", "Lkotlin/Lazy;", "deleteSuccess", "Ljava/util/HashSet;", "", "getDeleteSuccess", "()Ljava/util/HashSet;", "deleteSuccessState", "", "getDeleteSuccessState", "()Z", "setDeleteSuccessState", "(Z)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "liveList", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "getLiveList", "()Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "liveList$delegate", "mAdapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;", "getMAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "mAdapter$delegate", "mAlertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getMAlertDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "setMAlertDialog", "(Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;)V", "mContactManagerToptips", "Landroid/widget/TextView;", "getMContactManagerToptips", "()Landroid/widget/TextView;", "setMContactManagerToptips", "(Landroid/widget/TextView;)V", "mDeleteLabelBtn", "Landroid/widget/Button;", "getMDeleteLabelBtn", "()Landroid/widget/Button;", "setMDeleteLabelBtn", "(Landroid/widget/Button;)V", "mEditFooter", "Landroid/view/View;", "getMEditFooter", "()Landroid/view/View;", "setMEditFooter", "(Landroid/view/View;)V", "mEmptyView", "getMEmptyView", "setMEmptyView", "mHandler", "getMHandler", "mLayoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getMLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "setMLayoutManager", "(Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;)V", "mMainView", "getMMainView", "setMMainView", "mRecyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setMRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "menuItemClickListener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onItemClickListener", "com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$onItemClickListener$2$1;", "onItemClickListener$delegate", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealDelLabelBtn", "", "willDeleteLabels", "", "doDeleteScene", "memBerList", "doEdtAdapterLabel", "view", "contactDataItem", "doReportClick", "action", "", "actionInfo", "getCustomBounceId", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFTSSearchEnd", "p0", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNotifyChange", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showTextToast", "context", "Landroid/content/Context;", "msg", "yesRunable", "Ljava/lang/Runnable;", "updateBtnState", "names", "updateData", "loading", "updateOtherPagestate", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactManagerUI
  extends MMActivity
  implements com.tencent.mm.am.h, l, MStorageEx.IOnStorageChange
{
  public static final ContactManagerUI.a JXL;
  private final j CWU;
  private final j DHL;
  private final j FWi;
  private final j FWm;
  private final MenuItem.OnMenuItemClickListener JVE;
  private View JVc;
  private Button JVe;
  private final HashSet<String> JXD;
  private final int JXM;
  private WxRecyclerView JXN;
  private TextView JXO;
  private boolean JXP;
  private WxLinearLayoutManager JXQ;
  private View bEx;
  final MMHandler handler;
  private final MMHandler mHandler;
  String query;
  private w tipDialog;
  private View xTc;
  
  static
  {
    AppMethodBeat.i(268974);
    JXL = new ContactManagerUI.a((byte)0);
    AppMethodBeat.o(268974);
  }
  
  public ContactManagerUI()
  {
    AppMethodBeat.i(268867);
    this.JXM = com.tencent.mm.k.i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 50);
    this.query = "";
    this.handler = new MMHandler();
    this.JXD = new HashSet();
    this.mHandler = ((MMHandler)new f(this));
    this.DHL = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.FWi = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.CWU = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.FWm = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.JVE = new ContactManagerUI..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(268867);
  }
  
  private static void P(long paramLong, String paramString)
  {
    AppMethodBeat.i(268906);
    kotlin.g.b.s.u(paramString, "actionInfo");
    com.tencent.threadpool.h.ahAA.bm(new ContactManagerUI..ExternalSyntheticLambda7(paramLong, paramString));
    AppMethodBeat.o(268906);
  }
  
  private static final void Q(long paramLong, String paramString)
  {
    AppMethodBeat.i(268954);
    kotlin.g.b.s.u(paramString, "$actionInfo");
    kb localkb = new kb();
    localkb.ila = paramLong;
    localkb.sr(paramString);
    localkb.bMH();
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "24832 ,action = " + localkb.ila + ",actionInfo = " + localkb.iVn);
    AppMethodBeat.o(268954);
  }
  
  private static final void a(com.tencent.mm.modelmulti.h paramh, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(268944);
    kotlin.g.b.s.u(paramh, "$netscene");
    com.tencent.mm.kernel.h.baD().mCm.a((p)paramh);
    AppMethodBeat.o(268944);
  }
  
  private static final void a(ContactManagerUI paramContactManagerUI)
  {
    AppMethodBeat.i(268933);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    paramContactManagerUI.finish();
    AppMethodBeat.o(268933);
  }
  
  private static final void a(ContactManagerUI paramContactManagerUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(268950);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    if (paramInt == 0)
    {
      paramMenuItem = paramContactManagerUI.fTE();
      kotlin.g.b.s.checkNotNull(paramMenuItem);
      paramMenuItem = paramMenuItem.JXy;
      if ((paramMenuItem == null) || (paramMenuItem.isEmpty()))
      {
        Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
        AppMethodBeat.o(268950);
        return;
      }
      com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h(paramMenuItem, 1, 2, paramContactManagerUI.JXM);
      com.tencent.mm.kernel.h.baD().mCm.a((p)localh, 0);
      Context localContext = (Context)paramContactManagerUI.getContext();
      paramContactManagerUI.getString(R.l.app_tip);
      paramContactManagerUI.tipDialog = com.tencent.mm.ui.base.k.a(localContext, paramContactManagerUI.getString(R.l.gpZ), true, new ContactManagerUI..ExternalSyntheticLambda0(localh));
      P(4L, kotlin.g.b.s.X("", Integer.valueOf(paramMenuItem.size())));
    }
    AppMethodBeat.o(268950);
  }
  
  private static final void a(ContactManagerUI paramContactManagerUI, View paramView)
  {
    AppMethodBeat.i(268915);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContactManagerUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    paramView = paramContactManagerUI.fTE();
    kotlin.g.b.s.checkNotNull(paramView);
    paramContactManagerUI.iJ((List)paramView.JXz);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268915);
  }
  
  private static final void a(ContactManagerUI paramContactManagerUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(268948);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    params.a(0, paramContactManagerUI.getResources().getColor(R.e.fkI), (CharSequence)paramContactManagerUI.getString(R.l.gEe));
    AppMethodBeat.o(268948);
  }
  
  private static final void a(ContactManagerUI paramContactManagerUI, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(268922);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    paramContactManagerUI.hideVKB();
    if (!paramBoolean)
    {
      paramString = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage((Context)paramContactManagerUI.getContext());
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      com.tencent.mm.br.c.b((Context)paramContactManagerUI.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(268922);
  }
  
  private static final boolean a(ContactManagerUI paramContactManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(268911);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    paramContactManagerUI.finish();
    AppMethodBeat.o(268911);
    return false;
  }
  
  private static final void ap(boolean paramBoolean, String paramString) {}
  
  private static final void b(ContactManagerUI paramContactManagerUI)
  {
    AppMethodBeat.i(268938);
    kotlin.g.b.s.u(paramContactManagerUI, "this$0");
    c localc = paramContactManagerUI.fTD();
    if (localc != null)
    {
      paramContactManagerUI = paramContactManagerUI.query;
      kotlin.g.b.s.checkNotNull(paramContactManagerUI);
      localc.aEJ(paramContactManagerUI);
    }
    AppMethodBeat.o(268938);
  }
  
  private final com.tencent.mm.plugin.mvvmlist.g<a> fTF()
  {
    AppMethodBeat.i(268872);
    com.tencent.mm.plugin.mvvmlist.g localg = (com.tencent.mm.plugin.mvvmlist.g)this.CWU.getValue();
    AppMethodBeat.o(268872);
    return localg;
  }
  
  /* Error */
  private final void fTG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 731
    //   5: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 733	com/tencent/mm/autogen/a/abv
    //   11: dup
    //   12: invokespecial 734	com/tencent/mm/autogen/a/abv:<init>	()V
    //   15: astore_1
    //   16: aload_1
    //   17: getfield 738	com/tencent/mm/autogen/a/abv:ifq	Lcom/tencent/mm/autogen/a/abv$a;
    //   20: lconst_0
    //   21: putfield 743	com/tencent/mm/autogen/a/abv$a:delay	J
    //   24: aload_1
    //   25: invokevirtual 746	com/tencent/mm/autogen/a/abv:publish	()Z
    //   28: pop
    //   29: new 748	com/tencent/mm/autogen/a/abp
    //   32: dup
    //   33: invokespecial 749	com/tencent/mm/autogen/a/abp:<init>	()V
    //   36: invokevirtual 750	com/tencent/mm/autogen/a/abp:publish	()Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 752	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI:JXP	Z
    //   44: ifeq +37 -> 81
    //   47: aload_0
    //   48: getfield 317	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +53 -> 106
    //   56: aload_1
    //   57: new 754	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$$ExternalSyntheticLambda9
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 755	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$$ExternalSyntheticLambda9:<init>	(Lcom/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI;)V
    //   65: ldc2_w 756
    //   68: invokevirtual 761	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   71: pop
    //   72: ldc_w 731
    //   75: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: getfield 317	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +19 -> 106
    //   90: aload_1
    //   91: new 763	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$$ExternalSyntheticLambda8
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 764	com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$$ExternalSyntheticLambda8:<init>	(Lcom/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI;)V
    //   99: ldc2_w 765
    //   102: invokevirtual 761	com/tencent/mm/sdk/platformtools/MMHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   105: pop
    //   106: ldc_w 731
    //   109: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: goto -34 -> 78
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ContactManagerUI
    //   15	76	1	localObject1	Object
    //   115	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	115	finally
    //   56	78	115	finally
    //   81	86	115	finally
    //   90	106	115	finally
    //   106	112	115	finally
  }
  
  private void fTm()
  {
    TextView localTextView2 = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(268886);
    Object localObject1 = this.JVe;
    kotlin.g.b.s.checkNotNull(localObject1);
    Object localObject2 = fTE();
    kotlin.g.b.s.checkNotNull(localObject2);
    boolean bool;
    label96:
    label227:
    int i;
    if (((ContactDataItemList)localObject2).JXy.size() > 0)
    {
      bool = true;
      ((Button)localObject1).setEnabled(bool);
      localObject1 = fTE();
      kotlin.g.b.s.checkNotNull(localObject1);
      if (((ContactDataItemList)localObject1).JXy.size() <= 0) {
        break label316;
      }
      localObject1 = this.JVe;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((Button)localObject1).setTextColor(getResources().getColor(R.e.fkI));
      localObject1 = fTE();
      kotlin.g.b.s.checkNotNull(localObject1);
      if (((ContactDataItemList)localObject1).JXy.size() <= 0) {
        break label342;
      }
      localObject1 = this.JVe;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject2 = new StringBuilder().append(getResources().getString(R.l.fEU)).append(" (");
      ContactDataItemList localContactDataItemList = fTE();
      kotlin.g.b.s.checkNotNull(localContactDataItemList);
      ((Button)localObject1).setText((CharSequence)(localContactDataItemList.JXy.size() + ')'));
      label195:
      if (this.JXO == null) {
        break label485;
      }
      localObject1 = this.JXO;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((TextView)localObject1).setVisibility(0);
      localObject1 = fTD();
      if (localObject1 != null) {
        break label371;
      }
      localObject1 = null;
      kotlin.g.b.s.checkNotNull(localObject1);
      i = ((ArrayList)localObject1).size();
      if (i <= 1) {
        break label387;
      }
      localTextView2 = this.JXO;
      if (localTextView2 == null) {
        break label485;
      }
      localObject2 = getResources();
      i = R.l.gDd;
      localObject1 = fTD();
      if (localObject1 != null) {
        break label379;
      }
    }
    label316:
    label342:
    label371:
    label379:
    for (localObject1 = localTextView1;; localObject1 = ((c)localObject1).JXK)
    {
      kotlin.g.b.s.checkNotNull(localObject1);
      localTextView2.setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { ((ArrayList)localObject1).get(0) }));
      AppMethodBeat.o(268886);
      return;
      bool = false;
      break;
      localObject1 = this.JVe;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((Button)localObject1).setTextColor(getResources().getColor(R.e.black_text_color_disabled));
      break label96;
      localObject1 = this.JVe;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((Button)localObject1).setText((CharSequence)getResources().getString(R.l.fEU));
      break label195;
      localObject1 = ((c)localObject1).JXK;
      break label227;
    }
    label387:
    if (i == 1)
    {
      localTextView1 = this.JXO;
      if (localTextView1 != null)
      {
        localObject2 = getResources();
        i = R.l.gDe;
        localObject1 = fTD();
        if (localObject1 == null) {}
        for (localObject1 = localTextView2;; localObject1 = ((c)localObject1).JXK)
        {
          kotlin.g.b.s.checkNotNull(localObject1);
          localTextView1.setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { ((ArrayList)localObject1).get(0) }));
          AppMethodBeat.o(268886);
          return;
        }
      }
    }
    else
    {
      localObject1 = this.JXO;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    label485:
    AppMethodBeat.o(268886);
  }
  
  private final void iJ(List<a> paramList)
  {
    AppMethodBeat.i(268900);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(268900);
      return;
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)this, 1, true);
    localf.Vtg = new ContactManagerUI..ExternalSyntheticLambda3(this);
    Iterator localIterator = paramList.iterator();
    int i = 0;
    Object localObject1 = "";
    label365:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (a)localIterator.next();
        if (TextUtils.isEmpty((CharSequence)((a)localObject2).prR))
        {
          localObject2 = ((a)localObject2).contact;
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((az)localObject2).field_nickname)
          {
            localObject1 = kotlin.g.b.s.X((String)localObject1, localObject2);
            i += 1;
            if (i >= paramList.size()) {
              break label365;
            }
            localObject1 = kotlin.g.b.s.X((String)localObject1, "、");
            break;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
        localObject1 = ((a)localObject2).contact;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((az)localObject1).field_nickname)
        {
          localObject1 = localObject1 + '@' + ((a)localObject2).prR;
          break;
        }
      }
      Object localObject2 = "";
      if (paramList.size() > 1)
      {
        localObject2 = getString(R.l.gDY, new Object[] { String.valueOf(paramList.size()), localObject1 });
        kotlin.g.b.s.s(localObject2, "getString(R.string.del_c…ls.size.toString(), user)");
      }
      for (;;)
      {
        P(3L, "");
        localf.h((CharSequence)localObject2, 17, com.tencent.mm.cd.a.fromDPToPix((Context)this, 14));
        localf.GAC = new ContactManagerUI..ExternalSyntheticLambda4(this);
        localf.dDn();
        AppMethodBeat.o(268900);
        return;
        if (paramList.size() == 1)
        {
          localObject2 = getString(R.l.gDW, new Object[] { localObject1 });
          kotlin.g.b.s.s(localObject2, "getString(R.string.del_contact_dialog_title, user)");
        }
      }
    }
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(269047);
    fTm();
    AppMethodBeat.o(269047);
  }
  
  public final c fTD()
  {
    AppMethodBeat.i(269016);
    c localc = (c)this.DHL.getValue();
    AppMethodBeat.o(269016);
    return localc;
  }
  
  public final ContactDataItemList fTE()
  {
    AppMethodBeat.i(269018);
    ContactDataItemList localContactDataItemList = (ContactDataItemList)this.FWi.getValue();
    AppMethodBeat.o(269018);
    return localContactDataItemList;
  }
  
  public final int getCustomBounceId()
  {
    return R.h.fBI;
  }
  
  public final int getLayoutId()
  {
    return R.i.gix;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(269026);
    hideActionbarLine();
    this.query = getIntent().getStringExtra("contact_search_query");
    Object localObject = this.query;
    kotlin.g.b.s.checkNotNull(localObject);
    if (((String)localObject).length() > 10)
    {
      int i = R.l.gAC;
      localObject = this.query;
      kotlin.g.b.s.checkNotNull(localObject);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(269026);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(0, 11);
      kotlin.g.b.s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject = getString(i, new Object[] { kotlin.g.b.s.X((String)localObject, "...") });
      kotlin.g.b.s.s(localObject, "{\n            getString(…0, 11) + \"...\")\n        }");
    }
    for (;;)
    {
      setMMTitle((String)localObject);
      setBackBtn(this.JVE, R.k.actionbar_icon_dark_back);
      this.xTc = findViewById(R.h.fMe);
      this.bEx = findViewById(R.h.fLX);
      this.JXN = ((WxRecyclerView)findViewById(R.h.fBI));
      this.JXO = ((TextView)findViewById(R.h.fDc));
      this.JXQ = new WxLinearLayoutManager((Context)this);
      localObject = this.JXN;
      kotlin.g.b.s.checkNotNull(localObject);
      ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.JXQ);
      localObject = this.JXN;
      kotlin.g.b.s.checkNotNull(localObject);
      ((WxRecyclerView)localObject).setHasFixedSize(true);
      this.JVc = findViewById(R.h.edit_footer);
      this.JVe = ((Button)findViewById(R.h.fEX));
      localObject = this.JVe;
      if (localObject != null) {
        ((Button)localObject).setOnClickListener(new ContactManagerUI..ExternalSyntheticLambda2(this));
      }
      localObject = this.JXN;
      kotlin.g.b.s.checkNotNull(localObject);
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)fTF());
      localObject = fTD();
      if (localObject != null) {
        ((c)localObject).JXE = fTE();
      }
      localObject = fTD();
      if (localObject != null) {
        ((c)localObject).JXF = ((l)this);
      }
      localObject = fTF();
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).agOO = ((com.tencent.mm.view.recyclerview.h)this.FWm.getValue());
      }
      localObject = this.JVe;
      if (localObject != null) {
        ((Button)localObject).setEnabled(false);
      }
      com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 1L, 0L, 0L, 0L);
      AppMethodBeat.o(269026);
      return;
      localObject = getString(R.l.gAC, new Object[] { this.query });
      kotlin.g.b.s.s(localObject, "{\n            getString(…e_title, query)\n        }");
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269030);
    super.onCreate(paramBundle);
    initView();
    removeAllOptionMenu();
    paramBundle = this.JVc;
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.setVisibility(0);
    paramBundle = this.JVe;
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.setEnabled(false);
    paramBundle = this.JVe;
    kotlin.g.b.s.checkNotNull(paramBundle);
    paramBundle.setTextColor(getResources().getColor(R.e.black_text_color_disabled));
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add((MStorageEx.IOnStorageChange)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3990, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(269030);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269040);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove((MStorageEx.IOnStorageChange)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3990, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(269040);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(269041);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      AppMethodBeat.o(269041);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(269041);
    return bool;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(269037);
    kotlin.g.b.s.u(paramMStorageEx, "stg");
    kotlin.g.b.s.u(paramObject, "obj");
    Log.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(5001);
      this.mHandler.sendEmptyMessageDelayed(5001, 400L);
    }
    AppMethodBeat.o(269037);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(269046);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramp instanceof com.tencent.mm.modelmulti.h))
    {
      AppMethodBeat.o(269046);
      return;
    }
    if (this.tipDialog != null)
    {
      paramString = this.tipDialog;
      kotlin.g.b.s.checkNotNull(paramString);
      paramString.dismiss();
      this.tipDialog = null;
    }
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText((Context)this, (CharSequence)getString(R.l.gAD), 0).show();
      this.JXD.addAll((Collection)((com.tencent.mm.modelmulti.h)paramp).oLL);
      paramString = fTD();
      if (paramString != null)
      {
        localObject = this.JXD;
        kotlin.g.b.s.u(localObject, "<set-?>");
        paramString.JXD = ((HashSet)localObject);
      }
      paramString = ((com.tencent.mm.modelmulti.h)paramp).oLL;
      kotlin.g.b.s.s(paramString, "scene.names");
      kotlin.g.b.s.u(paramString, "names");
      paramp = fTE();
      kotlin.g.b.s.checkNotNull(paramp);
      paramp.JXy.removeAll((Collection)paramString);
      fTm();
      this.JXP = true;
      AppMethodBeat.o(269046);
      return;
    }
    if (paramInt2 == -3503)
    {
      paramString = new g.a((Context)this);
      paramString.bDE(Util.nullAs(paramp.getReqResp().getRespObj().getErrMsg(), getString(R.l.gAB))).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
      paramString.c(new ContactManagerUI..ExternalSyntheticLambda5(this)).show();
      AppMethodBeat.o(269046);
      return;
    }
    g.a locala = new g.a((Context)this);
    if (paramInt2 == -3500) {
      paramString = getString(R.l.gAz, new Object[] { Integer.valueOf(((com.tencent.mm.modelmulti.h)paramp).bKN()) });
    }
    for (;;)
    {
      paramString = locala.bDE(paramString);
      paramString.Xdm = true;
      paramString.aEX(R.l.app_ok);
      locala.b(ContactManagerUI..ExternalSyntheticLambda6.INSTANCE).show();
      AppMethodBeat.o(269046);
      return;
      localObject = paramp.getReqResp().getRespObj().getErrMsg();
      paramString = (String)localObject;
      if (Util.isNullOrNil((String)localObject)) {
        if (((com.tencent.mm.modelmulti.h)paramp).bKO() == null) {
          paramString = getString(R.l.gAA);
        } else {
          paramString = getString(R.l.gAB);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setMEditFooter(View paramView)
  {
    this.JVc = paramView;
  }
  
  public final void setMEmptyView(View paramView)
  {
    this.bEx = paramView;
  }
  
  public final void setMMainView(View paramView)
  {
    this.xTc = paramView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(ContactManagerUI paramContactManagerUI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(268929);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new b(this.JXR.fTE());
      AppMethodBeat.o(268929);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c>
  {
    c(ContactManagerUI paramContactManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ContactDataItemList>
  {
    d(ContactManagerUI paramContactManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<a>>
  {
    e(ContactManagerUI paramContactManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends MMHandler
  {
    f(ContactManagerUI paramContactManagerUI) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(268895);
      kotlin.g.b.s.u(paramMessage, "msg");
      int i = paramMessage.what;
      Log.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
      if (i == 5001) {
        ContactManagerUI.c(this.JXR);
      }
      AppMethodBeat.o(268895);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/label/ui/searchContact/ContactManagerUI$onItemClickListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<1>
  {
    g(ContactManagerUI paramContactManagerUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchContact.ContactManagerUI
 * JD-Core Version:    0.7.0.1
 */