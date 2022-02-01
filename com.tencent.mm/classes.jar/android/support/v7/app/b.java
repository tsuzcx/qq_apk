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
  final AlertController Wr = new AlertController(getContext(), this, getWindow());
  
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
    AlertController localAlertController = this.Wr;
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
    if ((localAlertController.VB != 0) && (localAlertController.VH == 1))
    {
      i = localAlertController.VB;
      localAlertController.UW.setContentView(i);
      paramBundle = localAlertController.UX.findViewById(2131303138);
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
        localAlertController.UX.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1052;
      }
      Object localObject5 = (FrameLayout)localAlertController.UX.findViewById(2131298900);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.Vf) {
        ((FrameLayout)localObject5).setPadding(localAlertController.Vb, localAlertController.Vc, localAlertController.Vd, localAlertController.Ve);
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
      localAlertController.Vs = ((NestedScrollView)localAlertController.UX.findViewById(2131304370));
      localAlertController.Vs.setFocusable(false);
      localAlertController.Vs.setNestedScrollingEnabled(false);
      localAlertController.Vx = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.Vx != null)
      {
        if (localAlertController.UZ == null) {
          break label1062;
        }
        localAlertController.Vx.setText(localAlertController.UZ);
      }
      i = 0;
      localAlertController.Vg = ((Button)paramBundle.findViewById(16908313));
      localAlertController.Vg.setOnClickListener(localAlertController.VI);
      if ((!TextUtils.isEmpty(localAlertController.Vh)) || (localAlertController.Vj != null)) {
        break label1156;
      }
      localAlertController.Vg.setVisibility(8);
      localAlertController.Vk = ((Button)paramBundle.findViewById(16908314));
      localAlertController.Vk.setOnClickListener(localAlertController.VI);
      if ((!TextUtils.isEmpty(localAlertController.Vl)) || (localAlertController.Vn != null)) {
        break label1227;
      }
      localAlertController.Vk.setVisibility(8);
      localAlertController.Vo = ((Button)paramBundle.findViewById(16908315));
      localAlertController.Vo.setOnClickListener(localAlertController.VI);
      if ((!TextUtils.isEmpty(localAlertController.Vp)) || (localAlertController.Vr != null)) {
        break label1300;
      }
      localAlertController.Vo.setVisibility(8);
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
        AlertController.a(localAlertController.Vg);
      }
      if (i == 0) {
        break label1410;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.Vy == null) {
        break label1415;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.Vy, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.UX.findViewById(2131305944).setVisibility(8);
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
      if (localAlertController.Vs != null) {
        localAlertController.Vs.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.UZ != null) || (localAlertController.mListView != null)) {
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
          localObject1 = localAlertController.UX.findViewById(2131304369);
          localObject2 = localAlertController.UX.findViewById(2131304368);
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
      if ((paramBundle != null) && (localAlertController.EN != null))
      {
        paramBundle.setAdapter(localAlertController.EN);
        i = localAlertController.Vz;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = localAlertController.VA;
      break;
      label1011:
      if (localAlertController.Va != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.Va, (ViewGroup)localObject1, false);
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
      localAlertController.Vx.setVisibility(8);
      localAlertController.Vs.removeView(localAlertController.Vx);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.Vs.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.Vs);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label350;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label350;
      label1156:
      localAlertController.Vg.setText(localAlertController.Vh);
      if (localAlertController.Vj != null)
      {
        localAlertController.Vj.setBounds(0, 0, localAlertController.UY, localAlertController.UY);
        localAlertController.Vg.setCompoundDrawables(localAlertController.Vj, null, null, null);
      }
      localAlertController.Vg.setVisibility(0);
      i = 1;
      break label408;
      label1227:
      localAlertController.Vk.setText(localAlertController.Vl);
      if (localAlertController.Vn != null)
      {
        localAlertController.Vn.setBounds(0, 0, localAlertController.UY, localAlertController.UY);
        localAlertController.Vk.setCompoundDrawables(localAlertController.Vn, null, null, null);
      }
      localAlertController.Vk.setVisibility(0);
      i |= 0x2;
      break label464;
      label1300:
      localAlertController.Vo.setText(localAlertController.Vp);
      if (localAlertController.Vj != null)
      {
        localAlertController.Vj.setBounds(0, 0, localAlertController.UY, localAlertController.UY);
        localAlertController.Vg.setCompoundDrawables(localAlertController.Vj, null, null, null);
      }
      localAlertController.Vo.setVisibility(0);
      i |= 0x4;
      break label520;
      label1373:
      j = 0;
      break label560;
      label1378:
      if (i == 2)
      {
        AlertController.a(localAlertController.Vk);
        break label577;
      }
      if (i != 4) {
        break label577;
      }
      AlertController.a(localAlertController.Vo);
      break label577;
      label1410:
      i = 0;
      break label583;
      label1415:
      localAlertController.Vv = ((ImageView)localAlertController.UX.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.Fm)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.VG))
        {
          localAlertController.Vw = ((TextView)localAlertController.UX.findViewById(2131296631));
          localAlertController.Vw.setText(localAlertController.Fm);
          if (localAlertController.Vt != 0)
          {
            localAlertController.Vv.setImageResource(localAlertController.Vt);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.Vu != null)
          {
            localAlertController.Vv.setImageDrawable(localAlertController.Vu);
            break;
          }
          localAlertController.Vw.setPadding(localAlertController.Vv.getPaddingLeft(), localAlertController.Vv.getPaddingTop(), localAlertController.Vv.getPaddingRight(), localAlertController.Vv.getPaddingBottom());
          localAlertController.Vv.setVisibility(8);
          break;
        }
      }
      localAlertController.UX.findViewById(2131305944).setVisibility(8);
      localAlertController.Vv.setVisibility(8);
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
      m = paramBundle.Wp;
      break label823;
      label1684:
      n = paramBundle.Wq;
      break label839;
      label1693:
      paramBundle = localAlertController.Vs;
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
        if (localAlertController.UZ != null)
        {
          localAlertController.Vs.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.Vs.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
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
    AlertController localAlertController = this.Wr;
    if ((localAlertController.Vs != null) && (localAlertController.Vs.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.Wr;
    if ((localAlertController.Vs != null) && (localAlertController.Vs.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.Wr.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a Ws;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.o(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.Ws = new AlertController.a(new ContextThemeWrapper(paramContext, b.o(paramContext, paramInt)));
      this.mTheme = paramInt;
    }
    
    public final b ga()
    {
      b localb = new b(this.Ws.mContext, this.mTheme);
      AlertController.a locala = this.Ws;
      AlertController localAlertController = localb.Wr;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label294:
      label335:
      label367:
      int i;
      if (locala.Vy != null)
      {
        localAlertController.Vy = locala.Vy;
        if (locala.UZ != null)
        {
          localObject = locala.UZ;
          localAlertController.UZ = ((CharSequence)localObject);
          if (localAlertController.Vx != null) {
            localAlertController.Vx.setText((CharSequence)localObject);
          }
        }
        if ((locala.VN != null) || (locala.VO != null)) {
          localAlertController.a(-1, locala.VN, locala.VP, null, locala.VO);
        }
        if ((locala.VQ != null) || (locala.VR != null)) {
          localAlertController.a(-2, locala.VQ, locala.VS, null, locala.VR);
        }
        if ((locala.VT != null) || (locala.VU != null)) {
          localAlertController.a(-3, locala.VT, locala.VV, null, locala.VU);
        }
        if ((locala.VZ != null) || (locala.Rn != null) || (locala.EN != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.VC, null);
          if (!locala.Wc) {
            break label732;
          }
          if (locala.Rn != null) {
            break label704;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.VD, locala.VZ, localRecycleListView);
          localAlertController.EN = ((ListAdapter)localObject);
          localAlertController.Vz = locala.Vz;
          if (locala.Wa == null) {
            break label848;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.Wh != null) {
            localRecycleListView.setOnItemSelectedListener(locala.Wh);
          }
          if (!locala.Wd) {
            break label877;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label919;
        }
        if (!locala.Vf) {
          break label894;
        }
        localObject = locala.mView;
        i = locala.Vb;
        int j = locala.Vc;
        int k = locala.Vd;
        int m = locala.Ve;
        localAlertController.mView = ((View)localObject);
        localAlertController.Va = 0;
        localAlertController.Vf = true;
        localAlertController.Vb = i;
        localAlertController.Vc = j;
        localAlertController.Vd = k;
        localAlertController.Ve = m;
      }
      for (;;)
      {
        localb.setCancelable(this.Ws.mCancelable);
        if (this.Ws.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.Ws.VW);
        localb.setOnDismissListener(this.Ws.VX);
        if (this.Ws.VY != null) {
          localb.setOnKeyListener(this.Ws.VY);
        }
        return localb;
        if (locala.Fm != null) {
          localAlertController.setTitle(locala.Fm);
        }
        if (locala.Vu != null)
        {
          localObject = locala.Vu;
          localAlertController.Vu = ((Drawable)localObject);
          localAlertController.Vt = 0;
          if (localAlertController.Vv != null)
          {
            if (localObject == null) {
              break label691;
            }
            localAlertController.Vv.setVisibility(0);
            localAlertController.Vv.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.Vt != 0) {
            localAlertController.setIcon(locala.Vt);
          }
          if (locala.VM == 0) {
            break;
          }
          i = locala.VM;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label691:
          localAlertController.Vv.setVisibility(8);
        }
        label704:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.Rn, localRecycleListView, localAlertController);
        break label294;
        label732:
        if (locala.Wd) {}
        for (i = localAlertController.VE;; i = localAlertController.VF)
        {
          if (locala.Rn == null) {
            break label807;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.Rn, new String[] { locala.Wf }, new int[] { 16908308 });
          break;
        }
        label807:
        if (locala.EN != null)
        {
          localObject = locala.EN;
          break label294;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.VZ);
        break label294;
        label848:
        if (locala.We == null) {
          break label335;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label335;
        label877:
        if (!locala.Wc) {
          break label367;
        }
        localRecycleListView.setChoiceMode(2);
        break label367;
        label894:
        localAlertController.mView = locala.mView;
        localAlertController.Va = 0;
        localAlertController.Vf = false;
        continue;
        label919:
        if (locala.Va != 0)
        {
          i = locala.Va;
          localAlertController.mView = null;
          localAlertController.Va = i;
          localAlertController.Vf = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.7.0.1
 */