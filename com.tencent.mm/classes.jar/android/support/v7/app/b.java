package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.u;
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
  final AlertController Yt = new AlertController(getContext(), this, getWindow());
  
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
    paramContext.getTheme().resolveAttribute(2130968645, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.Yt;
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
    if ((localAlertController.XD != 0) && (localAlertController.XJ == 1))
    {
      i = localAlertController.XD;
      localAlertController.WY.setContentView(i);
      paramBundle = localAlertController.WZ.findViewById(2131305780);
      localObject4 = paramBundle.findViewById(2131309297);
      localObject3 = paramBundle.findViewById(2131299184);
      localObject2 = paramBundle.findViewById(2131297895);
      localObject1 = (ViewGroup)paramBundle.findViewById(2131299379);
      if (localAlertController.mView == null) {
        break label1011;
      }
      paramBundle = localAlertController.mView;
      if (paramBundle == null) {
        break label1047;
      }
      i = 1;
      if ((i == 0) || (!AlertController.aZ(paramBundle))) {
        localAlertController.WZ.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1052;
      }
      Object localObject5 = (FrameLayout)localAlertController.WZ.findViewById(2131299378);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.Xh) {
        ((FrameLayout)localObject5).setPadding(localAlertController.Xd, localAlertController.Xe, localAlertController.Xf, localAlertController.Xg);
      }
      if (localAlertController.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).weight = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(2131309297);
      localObject5 = ((ViewGroup)localObject1).findViewById(2131299184);
      paramBundle = ((ViewGroup)localObject1).findViewById(2131297895);
      localObject4 = AlertController.d(localView, (View)localObject4);
      localObject3 = AlertController.d((View)localObject5, (View)localObject3);
      paramBundle = AlertController.d(paramBundle, (View)localObject2);
      localAlertController.Xu = ((NestedScrollView)localAlertController.WZ.findViewById(2131307332));
      localAlertController.Xu.setFocusable(false);
      localAlertController.Xu.setNestedScrollingEnabled(false);
      localAlertController.Xz = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.Xz != null)
      {
        if (localAlertController.Xb == null) {
          break label1062;
        }
        localAlertController.Xz.setText(localAlertController.Xb);
      }
      i = 0;
      localAlertController.Xi = ((Button)paramBundle.findViewById(16908313));
      localAlertController.Xi.setOnClickListener(localAlertController.XK);
      if ((!TextUtils.isEmpty(localAlertController.Xj)) || (localAlertController.Xl != null)) {
        break label1156;
      }
      localAlertController.Xi.setVisibility(8);
      localAlertController.Xm = ((Button)paramBundle.findViewById(16908314));
      localAlertController.Xm.setOnClickListener(localAlertController.XK);
      if ((!TextUtils.isEmpty(localAlertController.Xn)) || (localAlertController.Xp != null)) {
        break label1227;
      }
      localAlertController.Xm.setVisibility(8);
      localAlertController.Xq = ((Button)paramBundle.findViewById(16908315));
      localAlertController.Xq.setOnClickListener(localAlertController.XK);
      if ((!TextUtils.isEmpty(localAlertController.Xr)) || (localAlertController.Xt != null)) {
        break label1300;
      }
      localAlertController.Xq.setVisibility(8);
      localObject2 = localAlertController.mContext;
      localObject5 = new TypedValue();
      ((Context)localObject2).getTheme().resolveAttribute(2130968643, (TypedValue)localObject5, true);
      if (((TypedValue)localObject5).data == 0) {
        break label1373;
      }
      j = 1;
      if (j != 0)
      {
        if (i != 1) {
          break label1378;
        }
        AlertController.a(localAlertController.Xi);
      }
      if (i == 0) {
        break label1410;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.XA == null) {
        break label1415;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.XA, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.WZ.findViewById(2131309244).setVisibility(8);
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
        paramBundle = ((ViewGroup)localObject3).findViewById(2131308980);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if (k == 0) {
        break label1649;
      }
      if (localAlertController.Xu != null) {
        localAlertController.Xu.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.Xb != null) || (localAlertController.mListView != null)) {
        paramBundle = ((ViewGroup)localObject4).findViewById(2131309196);
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
          localObject1 = localAlertController.WZ.findViewById(2131307331);
          localObject2 = localAlertController.WZ.findViewById(2131307330);
          if (Build.VERSION.SDK_INT < 23) {
            break label1712;
          }
          u.w(paramBundle, i);
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
      if ((paramBundle != null) && (localAlertController.GO != null))
      {
        paramBundle.setAdapter(localAlertController.GO);
        i = localAlertController.XB;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = localAlertController.XC;
      break;
      label1011:
      if (localAlertController.Xc != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.Xc, (ViewGroup)localObject1, false);
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
      localAlertController.Xz.setVisibility(8);
      localAlertController.Xu.removeView(localAlertController.Xz);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.Xu.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.Xu);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label350;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label350;
      label1156:
      localAlertController.Xi.setText(localAlertController.Xj);
      if (localAlertController.Xl != null)
      {
        localAlertController.Xl.setBounds(0, 0, localAlertController.Xa, localAlertController.Xa);
        localAlertController.Xi.setCompoundDrawables(localAlertController.Xl, null, null, null);
      }
      localAlertController.Xi.setVisibility(0);
      i = 1;
      break label408;
      label1227:
      localAlertController.Xm.setText(localAlertController.Xn);
      if (localAlertController.Xp != null)
      {
        localAlertController.Xp.setBounds(0, 0, localAlertController.Xa, localAlertController.Xa);
        localAlertController.Xm.setCompoundDrawables(localAlertController.Xp, null, null, null);
      }
      localAlertController.Xm.setVisibility(0);
      i |= 0x2;
      break label464;
      label1300:
      localAlertController.Xq.setText(localAlertController.Xr);
      if (localAlertController.Xl != null)
      {
        localAlertController.Xl.setBounds(0, 0, localAlertController.Xa, localAlertController.Xa);
        localAlertController.Xi.setCompoundDrawables(localAlertController.Xl, null, null, null);
      }
      localAlertController.Xq.setVisibility(0);
      i |= 0x4;
      break label520;
      label1373:
      j = 0;
      break label560;
      label1378:
      if (i == 2)
      {
        AlertController.a(localAlertController.Xm);
        break label577;
      }
      if (i != 4) {
        break label577;
      }
      AlertController.a(localAlertController.Xq);
      break label577;
      label1410:
      i = 0;
      break label583;
      label1415:
      localAlertController.Xx = ((ImageView)localAlertController.WZ.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.Hn)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.XI))
        {
          localAlertController.Xy = ((TextView)localAlertController.WZ.findViewById(2131296708));
          localAlertController.Xy.setText(localAlertController.Hn);
          if (localAlertController.Xv != 0)
          {
            localAlertController.Xx.setImageResource(localAlertController.Xv);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.Xw != null)
          {
            localAlertController.Xx.setImageDrawable(localAlertController.Xw);
            break;
          }
          localAlertController.Xy.setPadding(localAlertController.Xx.getPaddingLeft(), localAlertController.Xx.getPaddingTop(), localAlertController.Xx.getPaddingRight(), localAlertController.Xx.getPaddingBottom());
          localAlertController.Xx.setVisibility(8);
          break;
        }
      }
      localAlertController.WZ.findViewById(2131309244).setVisibility(8);
      localAlertController.Xx.setVisibility(8);
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
      paramBundle = ((ViewGroup)localObject3).findViewById(2131308981);
      if (paramBundle == null) {
        break label777;
      }
      paramBundle.setVisibility(0);
      break label777;
      label1675:
      m = paramBundle.Yr;
      break label823;
      label1684:
      n = paramBundle.Ys;
      break label839;
      label1693:
      paramBundle = localAlertController.Xu;
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
        if (localAlertController.Xb != null)
        {
          localAlertController.Xu.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.Xu.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
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
    AlertController localAlertController = this.Yt;
    if ((localAlertController.Xu != null) && (localAlertController.Xu.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.Yt;
    if ((localAlertController.Xu != null) && (localAlertController.Xu.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.Yt.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a Yu;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.o(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.Yu = new AlertController.a(new ContextThemeWrapper(paramContext, b.o(paramContext, paramInt)));
      this.mTheme = paramInt;
    }
    
    public final b gz()
    {
      b localb = new b(this.Yu.mContext, this.mTheme);
      AlertController.a locala = this.Yu;
      AlertController localAlertController = localb.Yt;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label294:
      label335:
      label367:
      int i;
      if (locala.XA != null)
      {
        localAlertController.XA = locala.XA;
        if (locala.Xb != null)
        {
          localObject = locala.Xb;
          localAlertController.Xb = ((CharSequence)localObject);
          if (localAlertController.Xz != null) {
            localAlertController.Xz.setText((CharSequence)localObject);
          }
        }
        if ((locala.XP != null) || (locala.XQ != null)) {
          localAlertController.a(-1, locala.XP, locala.XR, null, locala.XQ);
        }
        if ((locala.XS != null) || (locala.XT != null)) {
          localAlertController.a(-2, locala.XS, locala.XU, null, locala.XT);
        }
        if ((locala.XV != null) || (locala.XW != null)) {
          localAlertController.a(-3, locala.XV, locala.XX, null, locala.XW);
        }
        if ((locala.Yb != null) || (locala.To != null) || (locala.GO != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.XE, null);
          if (!locala.Ye) {
            break label732;
          }
          if (locala.To != null) {
            break label704;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.XF, locala.Yb, localRecycleListView);
          localAlertController.GO = ((ListAdapter)localObject);
          localAlertController.XB = locala.XB;
          if (locala.Yc == null) {
            break label848;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.Yj != null) {
            localRecycleListView.setOnItemSelectedListener(locala.Yj);
          }
          if (!locala.Yf) {
            break label877;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label919;
        }
        if (!locala.Xh) {
          break label894;
        }
        localObject = locala.mView;
        i = locala.Xd;
        int j = locala.Xe;
        int k = locala.Xf;
        int m = locala.Xg;
        localAlertController.mView = ((View)localObject);
        localAlertController.Xc = 0;
        localAlertController.Xh = true;
        localAlertController.Xd = i;
        localAlertController.Xe = j;
        localAlertController.Xf = k;
        localAlertController.Xg = m;
      }
      for (;;)
      {
        localb.setCancelable(this.Yu.mCancelable);
        if (this.Yu.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.Yu.XY);
        localb.setOnDismissListener(this.Yu.XZ);
        if (this.Yu.Ya != null) {
          localb.setOnKeyListener(this.Yu.Ya);
        }
        return localb;
        if (locala.Hn != null) {
          localAlertController.setTitle(locala.Hn);
        }
        if (locala.Xw != null)
        {
          localObject = locala.Xw;
          localAlertController.Xw = ((Drawable)localObject);
          localAlertController.Xv = 0;
          if (localAlertController.Xx != null)
          {
            if (localObject == null) {
              break label691;
            }
            localAlertController.Xx.setVisibility(0);
            localAlertController.Xx.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.Xv != 0) {
            localAlertController.setIcon(locala.Xv);
          }
          if (locala.XO == 0) {
            break;
          }
          i = locala.XO;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label691:
          localAlertController.Xx.setVisibility(8);
        }
        label704:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.To, localRecycleListView, localAlertController);
        break label294;
        label732:
        if (locala.Yf) {}
        for (i = localAlertController.XG;; i = localAlertController.XH)
        {
          if (locala.To == null) {
            break label807;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.To, new String[] { locala.Yh }, new int[] { 16908308 });
          break;
        }
        label807:
        if (locala.GO != null)
        {
          localObject = locala.GO;
          break label294;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.Yb);
        break label294;
        label848:
        if (locala.Yg == null) {
          break label335;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label335;
        label877:
        if (!locala.Ye) {
          break label367;
        }
        localRecycleListView.setChoiceMode(2);
        break label367;
        label894:
        localAlertController.mView = locala.mView;
        localAlertController.Xc = 0;
        localAlertController.Xh = false;
        continue;
        label919:
        if (locala.Xc != 0)
        {
          i = locala.Xc;
          localAlertController.mView = null;
          localAlertController.Xc = i;
          localAlertController.Xh = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.7.0.1
 */