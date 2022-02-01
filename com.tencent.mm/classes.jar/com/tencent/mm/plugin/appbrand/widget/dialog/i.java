package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "showExplainIv", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class i
  extends Dialog
  implements k
{
  public static final a mBB;
  private DialogInterface.OnDismissListener VX;
  private final List<o.a> bYM;
  private View gDe;
  private String iconUrl;
  public View ijA;
  private int ikf;
  private String keG;
  private m kgA;
  private String kgC;
  private ImageView kgj;
  private TextView kgk;
  private ImageView kgm;
  private Button kgy;
  private Button kgz;
  private TextView lJb;
  private TextView lJc;
  private TextView lJe;
  private DialogInterface.OnShowListener lJh;
  private final boolean mBA;
  private LinearLayout mBo;
  private MaxHeightRecyclerView mBp;
  private TextView mBq;
  private View mBr;
  private o.b mBs;
  private b mBt;
  private o mBu;
  private String mBv;
  private String mBw;
  private String mBx;
  
  static
  {
    AppMethodBeat.i(148265);
    mBB = new a((byte)0);
    AppMethodBeat.o(148265);
  }
  
  public i(Context paramContext, b paramb, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(183078);
    this.mBA = paramBoolean;
    paramContext = View.inflate(n.ed(paramContext), 2131493051, null);
    d.g.b.k.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.ijA = paramContext;
    this.mBt = paramb;
    this.keG = "";
    this.bYM = ((List)new ArrayList());
    paramContext = this.ijA.findViewById(2131304100);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kgj = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131304102);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kgk = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304096);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kgz = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304103);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kgy = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304098);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.lJb = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304825);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lJc = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304097);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.mBo = ((LinearLayout)paramContext);
    paramContext = this.ijA.findViewById(2131304106);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.kgm = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131304095);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lJe = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304104);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mBp = ((MaxHeightRecyclerView)paramContext);
    this.mBp.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.mBu = new o(this.bYM);
    this.mBu.mBs = this.mBs;
    this.mBp.setAdapter((RecyclerView.a)this.mBu);
    paramContext = this.ijA.findViewById(2131304101);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.gDe = paramContext;
    paramContext = this.ijA.findViewById(2131297653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.mBr = paramContext;
    paramContext = this.ijA.findViewById(2131304099);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.mBq = ((TextView)paramContext);
    this.kgy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148227);
        paramAnonymousView = i.a(this.mBy, true);
        i.b localb = i.b(this.mBy);
        o.a locala = i.c(this.mBy);
        if (locala != null) {}
        for (int i = locala.keF;; i = 0)
        {
          localb.a(1, paramAnonymousView, i);
          paramAnonymousView = i.d(this.mBy);
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.c((k)this.mBy);
          AppMethodBeat.o(148227);
          return;
        }
        AppMethodBeat.o(148227);
      }
    });
    this.kgz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148228);
        paramAnonymousView = i.a(this.mBy, false);
        i.b.a.a(i.b(this.mBy), 2, paramAnonymousView);
        paramAnonymousView = i.d(this.mBy);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.c((k)this.mBy);
          AppMethodBeat.o(148228);
          return;
        }
        AppMethodBeat.o(148228);
      }
    });
    this.mBp.setItemAnimator(null);
    this.ikf = 2;
    AppMethodBeat.o(183078);
  }
  
  private final void sm(int paramInt)
  {
    AppMethodBeat.i(148252);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (final double d = 1.5D;; d = 2.5D)
    {
      this.mBp.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, d));
      this.mBp.invalidate();
      AppMethodBeat.o(148252);
      return;
    }
  }
  
  public final void MP(int paramInt)
  {
    AppMethodBeat.i(148258);
    this.mBq.setTextColor(paramInt);
    AppMethodBeat.o(148258);
  }
  
  public final void RP(String paramString)
  {
    AppMethodBeat.i(148245);
    this.kgC = paramString;
    TextView localTextView = this.kgk;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(148245);
      return;
    }
  }
  
  public final void RQ(String paramString)
  {
    AppMethodBeat.i(148246);
    this.mBv = paramString;
    this.lJb.setText((CharSequence)paramString);
    AppMethodBeat.o(148246);
  }
  
  public final void RR(String paramString)
  {
    AppMethodBeat.i(148247);
    this.mBw = paramString;
    if (paramString != null)
    {
      this.lJc.setVisibility(0);
      this.lJc.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(148247);
  }
  
  public final void RS(String paramString)
  {
    AppMethodBeat.i(148248);
    this.mBx = paramString;
    this.lJe.setText((CharSequence)paramString);
    AppMethodBeat.o(148248);
  }
  
  public final void Us(String paramString)
  {
    AppMethodBeat.i(148255);
    if (paramString != null)
    {
      this.kgz.setText((CharSequence)paramString);
      AppMethodBeat.o(148255);
      return;
    }
    AppMethodBeat.o(148255);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148259);
    this.mBq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148259);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148250);
    Object localObject = this.lJh;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.kgA = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.mCn;
      localObject = this.ijA.getContext();
      d.g.b.k.g(localObject, "mRootView.context");
      View localView1 = this.ijA;
      View localView2 = this.mBr;
      Display localDisplay = paramm.getDefaultDisplay();
      d.g.b.k.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), this.mBA);
      paramm = paramm.getDefaultDisplay();
      d.g.b.k.g(paramm, "it.defaultDisplay");
      sm(paramm.getRotation());
      AppMethodBeat.o(148250);
      return;
    }
    AppMethodBeat.o(148250);
  }
  
  public final void a(o.b paramb)
  {
    this.mBs = paramb;
    this.mBu.mBs = paramb;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(183077);
    d.g.b.k.h(paramc, "listener");
    this.mBu.mBG = paramc;
    AppMethodBeat.o(183077);
  }
  
  public final void aBP(String paramString)
  {
    AppMethodBeat.i(148257);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.mBq.setText((CharSequence)"");
      this.mBq.setVisibility(4);
      AppMethodBeat.o(148257);
      return;
    }
    this.mBq.setText((CharSequence)paramString);
    this.mBq.setVisibility(0);
    AppMethodBeat.o(148257);
  }
  
  public final void aBQ(String paramString)
  {
    AppMethodBeat.i(148263);
    d.g.b.k.h(paramString, "scope");
    this.keG = paramString;
    AppMethodBeat.o(148263);
  }
  
  public final boolean aLl()
  {
    return false;
  }
  
  public final boolean aLm()
  {
    return false;
  }
  
  public final void asC(String paramString)
  {
    AppMethodBeat.i(148256);
    if (paramString != null)
    {
      this.kgy.setText((CharSequence)paramString);
      AppMethodBeat.o(148256);
      return;
    }
    AppMethodBeat.o(148256);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148260);
    this.kgm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148260);
  }
  
  public final void bG(List<o.a> paramList)
  {
    AppMethodBeat.i(148262);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(148262);
        return;
      }
      this.bYM.clear();
      this.bYM.addAll((Collection)paramList);
      this.mBu.notifyDataSetChanged();
      this.mBo.setVisibility(0);
      this.lJc.setVisibility(8);
      this.gDe.setVisibility(8);
      AppMethodBeat.o(148262);
      return;
    }
    AppMethodBeat.o(148262);
  }
  
  public final void bsB()
  {
    AppMethodBeat.i(169659);
    this.ikf = 1;
    this.ijA.setBackground(android.support.v4.content.b.l(getContext(), 2131231061));
    AppMethodBeat.o(169659);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(148253);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.VX;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148253);
      return;
    }
    AppMethodBeat.o(148253);
  }
  
  public final View getContentView()
  {
    return this.ijA;
  }
  
  public final int getPosition()
  {
    return this.ikf;
  }
  
  public final void hW(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    ImageView localImageView = this.kgm;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(148261);
      return;
    }
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148254);
    i.b.a.a(this.mBt, 3, new ArrayList());
    AppMethodBeat.o(148254);
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(148251);
    Object localObject = n.mCn;
    localObject = this.ijA.getContext();
    d.g.b.k.g(localObject, "mRootView.context");
    n.a((Context)localObject, this.ijA, this.mBr, paramInt, this.mBA);
    sm(paramInt);
    AppMethodBeat.o(148251);
  }
  
  public final void qV(String paramString)
  {
    AppMethodBeat.i(148249);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.kgj, this.iconUrl, 2131233241, (b.h)g.htk);
    AppMethodBeat.o(148249);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2);
    
    @l(fNY={1, 1, 16})
    public static final class a {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(double paramDouble) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(169658);
      double d = d;
      int j = 0;
      int k = 0;
      if (d > 0.0D)
      {
        Object localObject = i.a(this.mBy).getLayoutManager();
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView.i)localObject).getChildAt(k);
          if (localObject != null)
          {
            i = ((View)localObject).getMeasuredHeight();
            label59:
            if (d < 1.0D) {
              break label114;
            }
          }
        }
        for (;;)
        {
          d -= 1.0D;
          k += 1;
          j = i + j;
          break;
          localObject = this.mBy.getContext();
          d.g.b.k.g(localObject, "context");
          i = ((Context)localObject).getResources().getDimensionPixelSize(2131165886);
          break label59;
          label114:
          i = (int)(i * d);
        }
      }
      i.a(this.mBy).setMaxHeight(j);
      i.a(this.mBy).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(169658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i
 * JD-Core Version:    0.7.0.1
 */