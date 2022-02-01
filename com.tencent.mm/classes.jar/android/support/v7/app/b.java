package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.t;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
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

public final class b
  extends e
  implements DialogInterface
{
  final AlertController Yg = new AlertController(getContext(), this, getWindow());
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, o(paramContext, paramInt));
  }
  
  static int o(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) > 0) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130968644, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.Yg;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label103:
    label109:
    int j;
    label219:
    label350:
    int k;
    label408:
    label464:
    int m;
    label520:
    label560:
    label577:
    label583:
    int n;
    if ((localAlertController.Xq != 0) && (localAlertController.Xw == 1))
    {
      i = localAlertController.Xq;
      localAlertController.WL.setContentView(i);
      paramBundle = localAlertController.WM.findViewById(2131303138);
      localObject4 = paramBundle.findViewById(2131305990);
      localObject3 = paramBundle.findViewById(2131298742);
      localObject2 = paramBundle.findViewById(2131297633);
      localObject1 = (ViewGroup)paramBundle.findViewById(2131298901);
      if (localAlertController.mView == null) {
        break label1011;
      }
      paramBundle = localAlertController.mView;
      if (paramBundle == null) {
        break label1047;
      }
      i = 1;
      if ((i == 0) || (!AlertController.aY(paramBundle))) {
        localAlertController.WM.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1052;
      }
      Object localObject5 = (FrameLayout)localAlertController.WM.findViewById(2131298900);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.WU) {
        ((FrameLayout)localObject5).setPadding(localAlertController.WQ, localAlertController.WR, localAlertController.WS, localAlertController.WT);
      }
      if (localAlertController.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).weight = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(2131305990);
      localObject5 = ((ViewGroup)localObject1).findViewById(2131298742);
      paramBundle = ((ViewGroup)localObject1).findViewById(2131297633);
      localObject4 = AlertController.d(localView, (View)localObject4);
      localObject3 = AlertController.d((View)localObject5, (View)localObject3);
      paramBundle = AlertController.d(paramBundle, (View)localObject2);
      localAlertController.Xh = ((NestedScrollView)localAlertController.WM.findViewById(2131304370));
      localAlertController.Xh.setFocusable(false);
      localAlertController.Xh.setNestedScrollingEnabled(false);
      localAlertController.Xm = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.Xm != null)
      {
        if (localAlertController.WO == null) {
          break label1062;
        }
        localAlertController.Xm.setText(localAlertController.WO);
      }
      i = 0;
      localAlertController.WV = ((Button)paramBundle.findViewById(16908313));
      localAlertController.WV.setOnClickListener(localAlertController.Xx);
      if ((!TextUtils.isEmpty(localAlertController.WW)) || (localAlertController.WY != null)) {
        break label1156;
      }
      localAlertController.WV.setVisibility(8);
      localAlertController.WZ = ((Button)paramBundle.findViewById(16908314));
      localAlertController.WZ.setOnClickListener(localAlertController.Xx);
      if ((!TextUtils.isEmpty(localAlertController.Xa)) || (localAlertController.Xc != null)) {
        break label1227;
      }
      localAlertController.WZ.setVisibility(8);
      localAlertController.Xd = ((Button)paramBundle.findViewById(16908315));
      localAlertController.Xd.setOnClickListener(localAlertController.Xx);
      if ((!TextUtils.isEmpty(localAlertController.Xe)) || (localAlertController.Xg != null)) {
        break label1300;
      }
      localAlertController.Xd.setVisibility(8);
      localObject2 = localAlertController.mContext;
      localObject5 = new TypedValue();
      ((Context)localObject2).getTheme().resolveAttribute(2130968642, (TypedValue)localObject5, true);
      if (((TypedValue)localObject5).data == 0) {
        break label1373;
      }
      j = 1;
      if (j != 0)
      {
        if (i != 1) {
          break label1378;
        }
        AlertController.a(localAlertController.WV);
      }
      if (i == 0) {
        break label1410;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.Xn == null) {
        break label1415;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.Xn, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.WM.findViewById(2131305944).setVisibility(8);
      label642:
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1633;
      }
      i = 1;
      label659:
      if ((localObject4 == null) || (((ViewGroup)localObject4).getVisibility() == 8)) {
        break label1638;
      }
      k = 1;
      label677:
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1644;
      }
      j = 1;
      label692:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(2131305713);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if (k == 0) {
        break label1649;
      }
      if (localAlertController.Xh != null) {
        localAlertController.Xh.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.WO != null) || (localAlertController.mListView != null)) {
        paramBundle = ((ViewGroup)localObject4).findViewById(2131305903);
      }
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      label777:
      if ((localAlertController.mListView instanceof AlertController.RecycleListView))
      {
        paramBundle = (AlertController.RecycleListView)localAlertController.mListView;
        if ((j == 0) || (k == 0))
        {
          int i1 = paramBundle.getPaddingLeft();
          if (k == 0) {
            break label1675;
          }
          m = paramBundle.getPaddingTop();
          label823:
          int i2 = paramBundle.getPaddingRight();
          if (j == 0) {
            break label1684;
          }
          n = paramBundle.getPaddingBottom();
          label839:
          paramBundle.setPadding(i1, m, i2, n);
        }
      }
      if (i == 0)
      {
        if (localAlertController.mListView == null) {
          break label1693;
        }
        paramBundle = localAlertController.mListView;
        label869:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1702;
          }
          i = 1;
          label880:
          if (j == 0) {
            break label1707;
          }
          j = 2;
          label886:
          i |= j;
          localObject1 = localAlertController.WM.findViewById(2131304369);
          localObject2 = localAlertController.WM.findViewById(2131304368);
          if (Build.VERSION.SDK_INT < 23) {
            break label1712;
          }
          t.w(paramBundle, i);
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
      if ((paramBundle != null) && (localAlertController.GE != null))
      {
        paramBundle.setAdapter(localAlertController.GE);
        i = localAlertController.Xo;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = localAlertController.Xp;
      break;
      label1011:
      if (localAlertController.WP != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.WP, (ViewGroup)localObject1, false);
        break label103;
      }
      paramBundle = null;
      break label103;
      label1047:
      i = 0;
      break label109;
      label1052:
      ((ViewGroup)localObject1).setVisibility(8);
      break label219;
      label1062:
      localAlertController.Xm.setVisibility(8);
      localAlertController.Xh.removeView(localAlertController.Xm);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.Xh.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.Xh);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label350;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label350;
      label1156:
      localAlertController.WV.setText(localAlertController.WW);
      if (localAlertController.WY != null)
      {
        localAlertController.WY.setBounds(0, 0, localAlertController.WN, localAlertController.WN);
        localAlertController.WV.setCompoundDrawables(localAlertController.WY, null, null, null);
      }
      localAlertController.WV.setVisibility(0);
      i = 1;
      break label408;
      label1227:
      localAlertController.WZ.setText(localAlertController.Xa);
      if (localAlertController.Xc != null)
      {
        localAlertController.Xc.setBounds(0, 0, localAlertController.WN, localAlertController.WN);
        localAlertController.WZ.setCompoundDrawables(localAlertController.Xc, null, null, null);
      }
      localAlertController.WZ.setVisibility(0);
      i |= 0x2;
      break label464;
      label1300:
      localAlertController.Xd.setText(localAlertController.Xe);
      if (localAlertController.WY != null)
      {
        localAlertController.WY.setBounds(0, 0, localAlertController.WN, localAlertController.WN);
        localAlertController.WV.setCompoundDrawables(localAlertController.WY, null, null, null);
      }
      localAlertController.Xd.setVisibility(0);
      i |= 0x4;
      break label520;
      label1373:
      j = 0;
      break label560;
      label1378:
      if (i == 2)
      {
        AlertController.a(localAlertController.WZ);
        break label577;
      }
      if (i != 4) {
        break label577;
      }
      AlertController.a(localAlertController.Xd);
      break label577;
      label1410:
      i = 0;
      break label583;
      label1415:
      localAlertController.Xk = ((ImageView)localAlertController.WM.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.Hd)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.Xv))
        {
          localAlertController.Xl = ((TextView)localAlertController.WM.findViewById(2131296631));
          localAlertController.Xl.setText(localAlertController.Hd);
          if (localAlertController.Xi != 0)
          {
            localAlertController.Xk.setImageResource(localAlertController.Xi);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.Xj != null)
          {
            localAlertController.Xk.setImageDrawable(localAlertController.Xj);
            break;
          }
          localAlertController.Xl.setPadding(localAlertController.Xk.getPaddingLeft(), localAlertController.Xk.getPaddingTop(), localAlertController.Xk.getPaddingRight(), localAlertController.Xk.getPaddingBottom());
          localAlertController.Xk.setVisibility(8);
          break;
        }
      }
      localAlertController.WM.findViewById(2131305944).setVisibility(8);
      localAlertController.Xk.setVisibility(8);
      ((ViewGroup)localObject4).setVisibility(8);
      break label642;
      label1633:
      i = 0;
      break label659;
      label1638:
      k = 0;
      break label677;
      label1644:
      j = 0;
      break label692;
      label1649:
      if (localObject3 == null) {
        break label777;
      }
      paramBundle = ((ViewGroup)localObject3).findViewById(2131305714);
      if (paramBundle == null) {
        break label777;
      }
      paramBundle.setVisibility(0);
      break label777;
      label1675:
      m = paramBundle.Ye;
      break label823;
      label1684:
      n = paramBundle.Yf;
      break label839;
      label1693:
      paramBundle = localAlertController.Xh;
      break label869;
      label1702:
      i = 0;
      break label880;
      label1707:
      j = 0;
      break label886;
      label1712:
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
        if (localAlertController.WO != null)
        {
          localAlertController.Xh.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.Xh.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
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
    AlertController localAlertController = this.Yg;
    if ((localAlertController.Xh != null) && (localAlertController.Xh.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.Yg;
    if ((localAlertController.Xh != null) && (localAlertController.Xh.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.Yg.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a Yh;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.o(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.Yh = new AlertController.a(new ContextThemeWrapper(paramContext, b.o(paramContext, paramInt)));
      this.mTheme = paramInt;
    }
    
    public final b gs()
    {
      b localb = new b(this.Yh.mContext, this.mTheme);
      AlertController.a locala = this.Yh;
      AlertController localAlertController = localb.Yg;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label294:
      label335:
      label367:
      int i;
      if (locala.Xn != null)
      {
        localAlertController.Xn = locala.Xn;
        if (locala.WO != null)
        {
          localObject = locala.WO;
          localAlertController.WO = ((CharSequence)localObject);
          if (localAlertController.Xm != null) {
            localAlertController.Xm.setText((CharSequence)localObject);
          }
        }
        if ((locala.XC != null) || (locala.XD != null)) {
          localAlertController.a(-1, locala.XC, locala.XE, null, locala.XD);
        }
        if ((locala.XF != null) || (locala.XG != null)) {
          localAlertController.a(-2, locala.XF, locala.XH, null, locala.XG);
        }
        if ((locala.XI != null) || (locala.XJ != null)) {
          localAlertController.a(-3, locala.XI, locala.XK, null, locala.XJ);
        }
        if ((locala.XO != null) || (locala.Tc != null) || (locala.GE != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.Xr, null);
          if (!locala.XR) {
            break label732;
          }
          if (locala.Tc != null) {
            break label704;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.Xs, locala.XO, localRecycleListView);
          localAlertController.GE = ((ListAdapter)localObject);
          localAlertController.Xo = locala.Xo;
          if (locala.XP == null) {
            break label848;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.XW != null) {
            localRecycleListView.setOnItemSelectedListener(locala.XW);
          }
          if (!locala.XS) {
            break label877;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label919;
        }
        if (!locala.WU) {
          break label894;
        }
        localObject = locala.mView;
        i = locala.WQ;
        int j = locala.WR;
        int k = locala.WS;
        int m = locala.WT;
        localAlertController.mView = ((View)localObject);
        localAlertController.WP = 0;
        localAlertController.WU = true;
        localAlertController.WQ = i;
        localAlertController.WR = j;
        localAlertController.WS = k;
        localAlertController.WT = m;
      }
      for (;;)
      {
        localb.setCancelable(this.Yh.mCancelable);
        if (this.Yh.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.Yh.XL);
        localb.setOnDismissListener(this.Yh.XM);
        if (this.Yh.XN != null) {
          localb.setOnKeyListener(this.Yh.XN);
        }
        return localb;
        if (locala.Hd != null) {
          localAlertController.setTitle(locala.Hd);
        }
        if (locala.Xj != null)
        {
          localObject = locala.Xj;
          localAlertController.Xj = ((Drawable)localObject);
          localAlertController.Xi = 0;
          if (localAlertController.Xk != null)
          {
            if (localObject == null) {
              break label691;
            }
            localAlertController.Xk.setVisibility(0);
            localAlertController.Xk.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.Xi != 0) {
            localAlertController.setIcon(locala.Xi);
          }
          if (locala.XB == 0) {
            break;
          }
          i = locala.XB;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label691:
          localAlertController.Xk.setVisibility(8);
        }
        label704:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.Tc, localRecycleListView, localAlertController);
        break label294;
        label732:
        if (locala.XS) {}
        for (i = localAlertController.Xt;; i = localAlertController.Xu)
        {
          if (locala.Tc == null) {
            break label807;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.Tc, new String[] { locala.XU }, new int[] { 16908308 });
          break;
        }
        label807:
        if (locala.GE != null)
        {
          localObject = locala.GE;
          break label294;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.XO);
        break label294;
        label848:
        if (locala.XT == null) {
          break label335;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label335;
        label877:
        if (!locala.XR) {
          break label367;
        }
        localRecycleListView.setChoiceMode(2);
        break label367;
        label894:
        localAlertController.mView = locala.mView;
        localAlertController.WP = 0;
        localAlertController.WU = false;
        continue;
        label919:
        if (locala.WP != 0)
        {
          i = locala.WP;
          localAlertController.mView = null;
          localAlertController.WP = i;
          localAlertController.WU = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.7.0.1
 */