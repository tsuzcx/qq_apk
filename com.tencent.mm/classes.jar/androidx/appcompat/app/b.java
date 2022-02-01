package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.a.a;
import androidx.appcompat.a.f;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.core.g.z;
import androidx.core.widget.NestedScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends e
  implements DialogInterface
{
  final AlertController gJ;
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, k(paramContext, paramInt));
    AppMethodBeat.i(200516);
    this.gJ = new AlertController(getContext(), this, getWindow());
    AppMethodBeat.o(200516);
  }
  
  static int k(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200526);
    if ((paramInt >>> 24 & 0xFF) > 0)
    {
      AppMethodBeat.o(200526);
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogTheme, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(200526);
    return paramInt;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200573);
    super.onCreate(paramBundle);
    AlertController localAlertController = this.gJ;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label113:
    label119:
    int j;
    label230:
    label365:
    int k;
    label423:
    label479:
    int m;
    label536:
    label577:
    label594:
    label600:
    int n;
    if ((localAlertController.fU != 0) && (localAlertController.ga == 1))
    {
      i = localAlertController.fU;
      localAlertController.fn.setContentView(i);
      paramBundle = localAlertController.fo.findViewById(a.f.parentPanel);
      localObject4 = paramBundle.findViewById(a.f.topPanel);
      localObject3 = paramBundle.findViewById(a.f.contentPanel);
      localObject2 = paramBundle.findViewById(a.f.buttonPanel);
      localObject1 = (ViewGroup)paramBundle.findViewById(a.f.customPanel);
      if (localAlertController.mView == null) {
        break label1033;
      }
      paramBundle = localAlertController.mView;
      if (paramBundle == null) {
        break label1069;
      }
      i = 1;
      if ((i == 0) || (!AlertController.d(paramBundle))) {
        localAlertController.fo.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1074;
      }
      Object localObject5 = (FrameLayout)localAlertController.fo.findViewById(a.f.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.fx) {
        ((FrameLayout)localObject5).setPadding(localAlertController.ft, localAlertController.fu, localAlertController.fv, localAlertController.fw);
      }
      if (localAlertController.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).qL = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(a.f.topPanel);
      localObject5 = ((ViewGroup)localObject1).findViewById(a.f.contentPanel);
      paramBundle = ((ViewGroup)localObject1).findViewById(a.f.buttonPanel);
      localObject4 = AlertController.b(localView, (View)localObject4);
      localObject3 = AlertController.b((View)localObject5, (View)localObject3);
      paramBundle = AlertController.b(paramBundle, (View)localObject2);
      localAlertController.fK = ((NestedScrollView)localAlertController.fo.findViewById(a.f.scrollView));
      localAlertController.fK.setFocusable(false);
      localAlertController.fK.setNestedScrollingEnabled(false);
      localAlertController.fP = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.fP != null)
      {
        if (localAlertController.fq == null) {
          break label1084;
        }
        localAlertController.fP.setText(localAlertController.fq);
      }
      i = 0;
      localAlertController.fy = ((Button)paramBundle.findViewById(16908313));
      localAlertController.fy.setOnClickListener(localAlertController.gb);
      if ((!TextUtils.isEmpty(localAlertController.fz)) || (localAlertController.fB != null)) {
        break label1178;
      }
      localAlertController.fy.setVisibility(8);
      localAlertController.fC = ((Button)paramBundle.findViewById(16908314));
      localAlertController.fC.setOnClickListener(localAlertController.gb);
      if ((!TextUtils.isEmpty(localAlertController.fD)) || (localAlertController.fF != null)) {
        break label1249;
      }
      localAlertController.fC.setVisibility(8);
      localAlertController.fG = ((Button)paramBundle.findViewById(16908315));
      localAlertController.fG.setOnClickListener(localAlertController.gb);
      if ((!TextUtils.isEmpty(localAlertController.fH)) || (localAlertController.fJ != null)) {
        break label1322;
      }
      localAlertController.fG.setVisibility(8);
      localObject2 = localAlertController.mContext;
      localObject5 = new TypedValue();
      ((Context)localObject2).getTheme().resolveAttribute(a.a.alertDialogCenterButtons, (TypedValue)localObject5, true);
      if (((TypedValue)localObject5).data == 0) {
        break label1395;
      }
      j = 1;
      if (j != 0)
      {
        if (i != 1) {
          break label1400;
        }
        AlertController.a(localAlertController.fy);
      }
      if (i == 0) {
        break label1432;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.fQ == null) {
        break label1437;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.fQ, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.fo.findViewById(a.f.title_template).setVisibility(8);
      label659:
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1655;
      }
      i = 1;
      label676:
      if ((localObject4 == null) || (((ViewGroup)localObject4).getVisibility() == 8)) {
        break label1660;
      }
      k = 1;
      label694:
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1666;
      }
      j = 1;
      label709:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(a.f.textSpacerNoButtons);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if (k == 0) {
        break label1671;
      }
      if (localAlertController.fK != null) {
        localAlertController.fK.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.fq != null) || (localAlertController.mListView != null)) {
        paramBundle = ((ViewGroup)localObject4).findViewById(a.f.titleDividerNoCustom);
      }
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      label794:
      if ((localAlertController.mListView instanceof AlertController.RecycleListView))
      {
        paramBundle = (AlertController.RecycleListView)localAlertController.mListView;
        if ((j == 0) || (k == 0))
        {
          int i1 = paramBundle.getPaddingLeft();
          if (k == 0) {
            break label1697;
          }
          m = paramBundle.getPaddingTop();
          label840:
          int i2 = paramBundle.getPaddingRight();
          if (j == 0) {
            break label1706;
          }
          n = paramBundle.getPaddingBottom();
          label856:
          paramBundle.setPadding(i1, m, i2, n);
        }
      }
      label897:
      label903:
      if (i == 0)
      {
        if (localAlertController.mListView == null) {
          break label1715;
        }
        paramBundle = localAlertController.mListView;
        label886:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1724;
          }
          i = 1;
          if (j == 0) {
            break label1729;
          }
          j = 2;
          i |= j;
          localObject1 = localAlertController.fo.findViewById(a.f.scrollIndicatorUp);
          localObject2 = localAlertController.fo.findViewById(a.f.scrollIndicatorDown);
          if (Build.VERSION.SDK_INT < 23) {
            break label1734;
          }
          z.w(paramBundle, i);
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
          if (localObject2 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = localAlertController.mListView;
      if ((paramBundle != null) && (localAlertController.fR != null))
      {
        paramBundle.setAdapter(localAlertController.fR);
        i = localAlertController.fS;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      AppMethodBeat.o(200573);
      return;
      i = localAlertController.fT;
      break;
      label1033:
      if (localAlertController.fs != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.fs, (ViewGroup)localObject1, false);
        break label113;
      }
      paramBundle = null;
      break label113;
      label1069:
      i = 0;
      break label119;
      label1074:
      ((ViewGroup)localObject1).setVisibility(8);
      break label230;
      label1084:
      localAlertController.fP.setVisibility(8);
      localAlertController.fK.removeView(localAlertController.fP);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.fK.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.fK);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label365;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label365;
      label1178:
      localAlertController.fy.setText(localAlertController.fz);
      if (localAlertController.fB != null)
      {
        localAlertController.fB.setBounds(0, 0, localAlertController.fp, localAlertController.fp);
        localAlertController.fy.setCompoundDrawables(localAlertController.fB, null, null, null);
      }
      localAlertController.fy.setVisibility(0);
      i = 1;
      break label423;
      label1249:
      localAlertController.fC.setText(localAlertController.fD);
      if (localAlertController.fF != null)
      {
        localAlertController.fF.setBounds(0, 0, localAlertController.fp, localAlertController.fp);
        localAlertController.fC.setCompoundDrawables(localAlertController.fF, null, null, null);
      }
      localAlertController.fC.setVisibility(0);
      i |= 0x2;
      break label479;
      label1322:
      localAlertController.fG.setText(localAlertController.fH);
      if (localAlertController.fB != null)
      {
        localAlertController.fB.setBounds(0, 0, localAlertController.fp, localAlertController.fp);
        localAlertController.fy.setCompoundDrawables(localAlertController.fB, null, null, null);
      }
      localAlertController.fG.setVisibility(0);
      i |= 0x4;
      break label536;
      label1395:
      j = 0;
      break label577;
      label1400:
      if (i == 2)
      {
        AlertController.a(localAlertController.fC);
        break label594;
      }
      if (i != 4) {
        break label594;
      }
      AlertController.a(localAlertController.fG);
      break label594;
      label1432:
      i = 0;
      break label600;
      label1437:
      localAlertController.fN = ((ImageView)localAlertController.fo.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.cZ)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.fZ))
        {
          localAlertController.fO = ((TextView)localAlertController.fo.findViewById(a.f.alertTitle));
          localAlertController.fO.setText(localAlertController.cZ);
          if (localAlertController.fL != 0)
          {
            localAlertController.fN.setImageResource(localAlertController.fL);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.fM != null)
          {
            localAlertController.fN.setImageDrawable(localAlertController.fM);
            break;
          }
          localAlertController.fO.setPadding(localAlertController.fN.getPaddingLeft(), localAlertController.fN.getPaddingTop(), localAlertController.fN.getPaddingRight(), localAlertController.fN.getPaddingBottom());
          localAlertController.fN.setVisibility(8);
          break;
        }
      }
      localAlertController.fo.findViewById(a.f.title_template).setVisibility(8);
      localAlertController.fN.setVisibility(8);
      ((ViewGroup)localObject4).setVisibility(8);
      break label659;
      label1655:
      i = 0;
      break label676;
      label1660:
      k = 0;
      break label694;
      label1666:
      j = 0;
      break label709;
      label1671:
      if (localObject3 == null) {
        break label794;
      }
      paramBundle = ((ViewGroup)localObject3).findViewById(a.f.textSpacerNoTitle);
      if (paramBundle == null) {
        break label794;
      }
      paramBundle.setVisibility(0);
      break label794;
      label1697:
      m = paramBundle.gH;
      break label840;
      label1706:
      n = paramBundle.gI;
      break label856;
      label1715:
      paramBundle = localAlertController.fK;
      break label886;
      label1724:
      i = 0;
      break label897;
      label1729:
      j = 0;
      break label903;
      label1734:
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if ((i & 0x1) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject1);
          paramBundle = null;
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((i & 0x2) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject1 = null;
        }
      }
      if ((paramBundle != null) || (localObject1 != null)) {
        if (localAlertController.fq != null)
        {
          localAlertController.fK.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.fK.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
        }
        else if (localAlertController.mListView != null)
        {
          localAlertController.mListView.setOnScrollListener(new AlertController.4(localAlertController, paramBundle, (View)localObject1));
          localAlertController.mListView.post(new AlertController.5(localAlertController, paramBundle, (View)localObject1));
        }
        else
        {
          if (paramBundle != null) {
            ((ViewGroup)localObject3).removeView(paramBundle);
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200583);
    AlertController localAlertController = this.gJ;
    if ((localAlertController.fK != null) && (localAlertController.fK.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(200583);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(200583);
    return bool;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200591);
    AlertController localAlertController = this.gJ;
    if ((localAlertController.fK != null) && (localAlertController.fK.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(200591);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(200591);
    return bool;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200531);
    super.setTitle(paramCharSequence);
    this.gJ.setTitle(paramCharSequence);
    AppMethodBeat.o(200531);
  }
  
  public static final class a
  {
    public final AlertController.a gK;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.k(paramContext, 0));
      AppMethodBeat.i(200490);
      AppMethodBeat.o(200490);
    }
    
    private a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(200498);
      this.gK = new AlertController.a(new ContextThemeWrapper(paramContext, b.k(paramContext, paramInt)));
      this.mTheme = paramInt;
      AppMethodBeat.o(200498);
    }
    
    public final b bA()
    {
      AppMethodBeat.i(200519);
      b localb = new b(this.gK.mContext, this.mTheme);
      AlertController.a locala = this.gK;
      AlertController localAlertController = localb.gJ;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label299:
      label340:
      label372:
      int i;
      if (locala.fQ != null)
      {
        localAlertController.fQ = locala.fQ;
        if (locala.fq != null)
        {
          localObject = locala.fq;
          localAlertController.fq = ((CharSequence)localObject);
          if (localAlertController.fP != null) {
            localAlertController.fP.setText((CharSequence)localObject);
          }
        }
        if ((locala.gg != null) || (locala.gh != null)) {
          localAlertController.a(-1, locala.gg, locala.gi, null, locala.gh);
        }
        if ((locala.gj != null) || (locala.gk != null)) {
          localAlertController.a(-2, locala.gj, locala.gl, null, locala.gk);
        }
        if ((locala.gm != null) || (locala.gn != null)) {
          localAlertController.a(-3, locala.gm, locala.go, null, locala.gn);
        }
        if ((locala.gq != null) || (locala.gw != null) || (locala.fR != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.fV, null);
          if (!locala.gt) {
            break label742;
          }
          if (locala.gw != null) {
            break label714;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.fW, locala.gq, localRecycleListView);
          localAlertController.fR = ((ListAdapter)localObject);
          localAlertController.fS = locala.fS;
          if (locala.gr == null) {
            break label858;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.gz != null) {
            localRecycleListView.setOnItemSelectedListener(locala.gz);
          }
          if (!locala.gu) {
            break label887;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label929;
        }
        if (!locala.fx) {
          break label904;
        }
        localObject = locala.mView;
        i = locala.ft;
        int j = locala.fu;
        int k = locala.fv;
        int m = locala.fw;
        localAlertController.mView = ((View)localObject);
        localAlertController.fs = 0;
        localAlertController.fx = true;
        localAlertController.ft = i;
        localAlertController.fu = j;
        localAlertController.fv = k;
        localAlertController.fw = m;
      }
      for (;;)
      {
        localb.setCancelable(this.gK.mCancelable);
        if (this.gK.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.gK.mOnCancelListener);
        localb.setOnDismissListener(this.gK.mOnDismissListener);
        if (this.gK.gp != null) {
          localb.setOnKeyListener(this.gK.gp);
        }
        AppMethodBeat.o(200519);
        return localb;
        if (locala.cZ != null) {
          localAlertController.setTitle(locala.cZ);
        }
        if (locala.fM != null)
        {
          localObject = locala.fM;
          localAlertController.fM = ((Drawable)localObject);
          localAlertController.fL = 0;
          if (localAlertController.fN != null)
          {
            if (localObject == null) {
              break label701;
            }
            localAlertController.fN.setVisibility(0);
            localAlertController.fN.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.fL != 0) {
            localAlertController.setIcon(locala.fL);
          }
          if (locala.gf == 0) {
            break;
          }
          i = locala.gf;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label701:
          localAlertController.fN.setVisibility(8);
        }
        label714:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.gw, localRecycleListView, localAlertController);
        break label299;
        label742:
        if (locala.gu) {}
        for (i = localAlertController.fX;; i = localAlertController.fY)
        {
          if (locala.gw == null) {
            break label817;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.gw, new String[] { locala.gx }, new int[] { 16908308 });
          break;
        }
        label817:
        if (locala.fR != null)
        {
          localObject = locala.fR;
          break label299;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.gq);
        break label299;
        label858:
        if (locala.gv == null) {
          break label340;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label340;
        label887:
        if (!locala.gt) {
          break label372;
        }
        localRecycleListView.setChoiceMode(2);
        break label372;
        label904:
        localAlertController.mView = locala.mView;
        localAlertController.fs = 0;
        localAlertController.fx = false;
        continue;
        label929:
        if (locala.fs != 0)
        {
          i = locala.fs;
          localAlertController.mView = null;
          localAlertController.fs = i;
          localAlertController.fx = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.b
 * JD-Core Version:    0.7.0.1
 */