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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "showExplainIv", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class i
  extends Dialog
  implements k
{
  public static final i.a KDt;
  private LinearLayout KDj;
  private MaxHeightRecyclerView KDk;
  private TextView KDl;
  private View KDm;
  private b KDn;
  private o KDo;
  private String KDp;
  private String KDq;
  private String KDr;
  private final boolean KDs;
  private DialogInterface.OnDismissListener Vc;
  private final List<o.a> cbP;
  public View hIZ;
  private int hJH;
  private String iconUrl;
  private String jEj;
  private ImageView jFL;
  private TextView jFM;
  private ImageView jFO;
  private Button jGa;
  private Button jGb;
  private m jGc;
  private String jGe;
  private View lZo;
  private o.b lZr;
  private TextView ljj;
  private TextView ljk;
  private TextView ljm;
  private DialogInterface.OnShowListener ljp;
  
  static
  {
    AppMethodBeat.i(148265);
    KDt = new i.a((byte)0);
    AppMethodBeat.o(148265);
  }
  
  public i(Context paramContext, b paramb, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(183078);
    this.KDs = paramBoolean;
    paramContext = View.inflate(n.kP(paramContext), 2131493051, null);
    d.g.b.k.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.hIZ = paramContext;
    this.KDn = paramb;
    this.jEj = "";
    this.cbP = ((List)new ArrayList());
    paramContext = this.hIZ.findViewById(2131304100);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.jFL = ((ImageView)paramContext);
    paramContext = this.hIZ.findViewById(2131304102);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.jFM = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304096);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.jGb = ((Button)paramContext);
    paramContext = this.hIZ.findViewById(2131304103);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.jGa = ((Button)paramContext);
    paramContext = this.hIZ.findViewById(2131304098);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.ljj = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304825);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.ljk = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304097);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.KDj = ((LinearLayout)paramContext);
    paramContext = this.hIZ.findViewById(2131304106);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.jFO = ((ImageView)paramContext);
    paramContext = this.hIZ.findViewById(2131304095);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.ljm = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304104);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.KDk = ((MaxHeightRecyclerView)paramContext);
    this.KDk.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.KDo = new o(this.cbP);
    this.KDo.lZr = this.lZr;
    this.KDk.setAdapter((RecyclerView.a)this.KDo);
    paramContext = this.hIZ.findViewById(2131304101);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.lZo = paramContext;
    paramContext = this.hIZ.findViewById(2131297653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.KDm = paramContext;
    paramContext = this.hIZ.findViewById(2131304099);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.KDl = ((TextView)paramContext);
    this.jGa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148227);
        paramAnonymousView = i.a(this.lZx, true);
        i.b localb = i.b(this.lZx);
        o.a locala = i.c(this.lZx);
        if (locala != null) {}
        for (int i = locala.jEi;; i = 0)
        {
          localb.a(1, paramAnonymousView, i);
          paramAnonymousView = i.d(this.lZx);
          if (paramAnonymousView == null) {
            break;
          }
          paramAnonymousView.c((k)this.lZx);
          AppMethodBeat.o(148227);
          return;
        }
        AppMethodBeat.o(148227);
      }
    });
    this.jGb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148228);
        paramAnonymousView = i.a(this.lZx, false);
        i.b.a.a(i.b(this.lZx), 2, paramAnonymousView);
        paramAnonymousView = i.d(this.lZx);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.c((k)this.lZx);
          AppMethodBeat.o(148228);
          return;
        }
        AppMethodBeat.o(148228);
      }
    });
    this.KDk.setItemAnimator(null);
    this.hJH = 2;
    AppMethodBeat.o(183078);
  }
  
  private final void rx(int paramInt)
  {
    AppMethodBeat.i(148252);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (final double d = 1.5D;; d = 2.5D)
    {
      this.KDk.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, d));
      this.KDk.invalidate();
      AppMethodBeat.o(148252);
      return;
    }
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148259);
    this.KDl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148259);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148250);
    Object localObject = this.ljp;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.jGc = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.KDx;
      localObject = this.hIZ.getContext();
      d.g.b.k.g(localObject, "mRootView.context");
      View localView1 = this.hIZ;
      View localView2 = this.KDm;
      Display localDisplay = paramm.getDefaultDisplay();
      d.g.b.k.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), this.KDs);
      paramm = paramm.getDefaultDisplay();
      d.g.b.k.g(paramm, "it.defaultDisplay");
      rx(paramm.getRotation());
      AppMethodBeat.o(148250);
      return;
    }
    AppMethodBeat.o(148250);
  }
  
  public final void a(o.b paramb)
  {
    this.lZr = paramb;
    this.KDo.lZr = paramb;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(183077);
    d.g.b.k.h(paramc, "listener");
    this.KDo.lZF = paramc;
    AppMethodBeat.o(183077);
  }
  
  public final boolean aEu()
  {
    return false;
  }
  
  public final boolean aEv()
  {
    return false;
  }
  
  public final void aUE(String paramString)
  {
    AppMethodBeat.i(148245);
    this.jGe = paramString;
    TextView localTextView = this.jFM;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(148245);
      return;
    }
  }
  
  public final void aUF(String paramString)
  {
    AppMethodBeat.i(148246);
    this.KDp = paramString;
    this.ljj.setText((CharSequence)paramString);
    AppMethodBeat.o(148246);
  }
  
  public final void aUG(String paramString)
  {
    AppMethodBeat.i(148247);
    this.KDq = paramString;
    if (paramString != null)
    {
      this.ljk.setVisibility(0);
      this.ljk.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(148247);
  }
  
  public final void aUH(String paramString)
  {
    AppMethodBeat.i(148248);
    this.KDr = paramString;
    this.ljm.setText((CharSequence)paramString);
    AppMethodBeat.o(148248);
  }
  
  public final void aUI(String paramString)
  {
    AppMethodBeat.i(148255);
    if (paramString != null)
    {
      this.jGb.setText((CharSequence)paramString);
      AppMethodBeat.o(148255);
      return;
    }
    AppMethodBeat.o(148255);
  }
  
  public final void aUJ(String paramString)
  {
    AppMethodBeat.i(148256);
    if (paramString != null)
    {
      this.jGa.setText((CharSequence)paramString);
      AppMethodBeat.o(148256);
      return;
    }
    AppMethodBeat.o(148256);
  }
  
  public final void aUK(String paramString)
  {
    AppMethodBeat.i(148257);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.KDl.setText((CharSequence)"");
      this.KDl.setVisibility(4);
      AppMethodBeat.o(148257);
      return;
    }
    this.KDl.setText((CharSequence)paramString);
    this.KDl.setVisibility(0);
    AppMethodBeat.o(148257);
  }
  
  public final void aUL(String paramString)
  {
    AppMethodBeat.i(148263);
    d.g.b.k.h(paramString, "scope");
    this.jEj = paramString;
    AppMethodBeat.o(148263);
  }
  
  public final void agO(int paramInt)
  {
    AppMethodBeat.i(148258);
    this.KDl.setTextColor(paramInt);
    AppMethodBeat.o(148258);
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148260);
    this.jFO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148260);
  }
  
  public final void dA(List<o.a> paramList)
  {
    AppMethodBeat.i(148262);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(148262);
        return;
      }
      this.cbP.clear();
      this.cbP.addAll((Collection)paramList);
      this.KDo.notifyDataSetChanged();
      this.KDj.setVisibility(0);
      this.ljk.setVisibility(8);
      this.lZo.setVisibility(8);
      AppMethodBeat.o(148262);
      return;
    }
    AppMethodBeat.o(148262);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(148253);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.Vc;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148253);
      return;
    }
    AppMethodBeat.o(148253);
  }
  
  public final void fQY()
  {
    AppMethodBeat.i(169659);
    this.hJH = 1;
    this.hIZ.setBackground(android.support.v4.content.b.l(getContext(), 2131231061));
    AppMethodBeat.o(169659);
  }
  
  public final View getContentView()
  {
    return this.hIZ;
  }
  
  public final int getPosition()
  {
    return this.hJH;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void nP(String paramString)
  {
    AppMethodBeat.i(148249);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aub().a(this.jFL, this.iconUrl, 2131233241, (b.h)g.gSK);
    AppMethodBeat.o(148249);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148254);
    i.b.a.a(this.KDn, 3, new ArrayList());
    AppMethodBeat.o(148254);
  }
  
  public final void pi(int paramInt)
  {
    AppMethodBeat.i(148251);
    Object localObject = n.KDx;
    localObject = this.hIZ.getContext();
    d.g.b.k.g(localObject, "mRootView.context");
    n.a((Context)localObject, this.hIZ, this.KDm, paramInt, this.KDs);
    rx(paramInt);
    AppMethodBeat.o(148251);
  }
  
  public final void yt(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    ImageView localImageView = this.jFO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(148261);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2);
    
    @l(fvt={1, 1, 16})
    public static final class a {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
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
        Object localObject = i.a(this.lZx).getLayoutManager();
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
          localObject = this.lZx.getContext();
          d.g.b.k.g(localObject, "context");
          i = ((Context)localObject).getResources().getDimensionPixelSize(2131165886);
          break label59;
          label114:
          i = (int)(i * d);
        }
      }
      i.a(this.lZx).setMaxHeight(j);
      i.a(this.lZx).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(169658);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i
 * JD-Core Version:    0.7.0.1
 */