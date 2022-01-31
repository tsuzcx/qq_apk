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
  public final AlertController Or = new AlertController(getContext(), this, getWindow());
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, n(paramContext, paramInt));
  }
  
  static int n(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) > 0) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130772219, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.Or;
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
    if ((localAlertController.NB != 0) && (localAlertController.NH == 1))
    {
      i = localAlertController.NB;
      localAlertController.MZ.setContentView(i);
      paramBundle = localAlertController.Na.findViewById(2131820932);
      localObject4 = paramBundle.findViewById(2131820941);
      localObject3 = paramBundle.findViewById(2131820933);
      localObject2 = paramBundle.findViewById(2131820930);
      localObject1 = (ViewGroup)paramBundle.findViewById(2131820939);
      if (localAlertController.mView == null) {
        break label1011;
      }
      paramBundle = localAlertController.mView;
      if (paramBundle == null) {
        break label1047;
      }
      i = 1;
      if ((i == 0) || (!AlertController.aS(paramBundle))) {
        localAlertController.Na.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1052;
      }
      Object localObject5 = (FrameLayout)localAlertController.Na.findViewById(2131820940);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.Ni) {
        ((FrameLayout)localObject5).setPadding(localAlertController.Ne, localAlertController.Nf, localAlertController.Ng, localAlertController.Nh);
      }
      if (localAlertController.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).weight = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(2131820941);
      localObject5 = ((ViewGroup)localObject1).findViewById(2131820933);
      paramBundle = ((ViewGroup)localObject1).findViewById(2131820930);
      localObject4 = AlertController.c(localView, (View)localObject4);
      localObject3 = AlertController.c((View)localObject5, (View)localObject3);
      paramBundle = AlertController.c(paramBundle, (View)localObject2);
      localAlertController.Nv = ((NestedScrollView)localAlertController.Na.findViewById(2131820935));
      localAlertController.Nv.setFocusable(false);
      localAlertController.Nv.setNestedScrollingEnabled(false);
      localAlertController.fc = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.fc != null)
      {
        if (localAlertController.Nc == null) {
          break label1062;
        }
        localAlertController.fc.setText(localAlertController.Nc);
      }
      i = 0;
      localAlertController.Nj = ((Button)paramBundle.findViewById(16908313));
      localAlertController.Nj.setOnClickListener(localAlertController.NI);
      if ((!TextUtils.isEmpty(localAlertController.Nk)) || (localAlertController.Nm != null)) {
        break label1156;
      }
      localAlertController.Nj.setVisibility(8);
      localAlertController.Nn = ((Button)paramBundle.findViewById(16908314));
      localAlertController.Nn.setOnClickListener(localAlertController.NI);
      if ((!TextUtils.isEmpty(localAlertController.No)) || (localAlertController.Nq != null)) {
        break label1227;
      }
      localAlertController.Nn.setVisibility(8);
      localAlertController.Nr = ((Button)paramBundle.findViewById(16908315));
      localAlertController.Nr.setOnClickListener(localAlertController.NI);
      if ((!TextUtils.isEmpty(localAlertController.Ns)) || (localAlertController.Nu != null)) {
        break label1300;
      }
      localAlertController.Nr.setVisibility(8);
      localObject2 = localAlertController.mContext;
      localObject5 = new TypedValue();
      ((Context)localObject2).getTheme().resolveAttribute(2130772218, (TypedValue)localObject5, true);
      if (((TypedValue)localObject5).data == 0) {
        break label1373;
      }
      j = 1;
      if (j != 0)
      {
        if (i != 1) {
          break label1378;
        }
        AlertController.a(localAlertController.Nj);
      }
      if (i == 0) {
        break label1410;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.Ny == null) {
        break label1415;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.Ny, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.Na.findViewById(2131820942).setVisibility(8);
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
        paramBundle = ((ViewGroup)localObject3).findViewById(2131820937);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if (k == 0) {
        break label1649;
      }
      if (localAlertController.Nv != null) {
        localAlertController.Nv.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.Nc != null) || (localAlertController.mListView != null)) {
        paramBundle = ((ViewGroup)localObject4).findViewById(2131820944);
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
          localObject1 = localAlertController.Na.findViewById(2131820934);
          localObject2 = localAlertController.Na.findViewById(2131820938);
          if (Build.VERSION.SDK_INT < 23) {
            break label1712;
          }
          t.u(paramBundle, i);
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
      if ((paramBundle != null) && (localAlertController.xw != null))
      {
        paramBundle.setAdapter(localAlertController.xw);
        i = localAlertController.Nz;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = localAlertController.NA;
      break;
      label1011:
      if (localAlertController.Nd != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.Nd, (ViewGroup)localObject1, false);
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
      localAlertController.fc.setVisibility(8);
      localAlertController.Nv.removeView(localAlertController.fc);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.Nv.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.Nv);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label350;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label350;
      label1156:
      localAlertController.Nj.setText(localAlertController.Nk);
      if (localAlertController.Nm != null)
      {
        localAlertController.Nm.setBounds(0, 0, localAlertController.Nb, localAlertController.Nb);
        localAlertController.Nj.setCompoundDrawables(localAlertController.Nm, null, null, null);
      }
      localAlertController.Nj.setVisibility(0);
      i = 1;
      break label408;
      label1227:
      localAlertController.Nn.setText(localAlertController.No);
      if (localAlertController.Nq != null)
      {
        localAlertController.Nq.setBounds(0, 0, localAlertController.Nb, localAlertController.Nb);
        localAlertController.Nn.setCompoundDrawables(localAlertController.Nq, null, null, null);
      }
      localAlertController.Nn.setVisibility(0);
      i |= 0x2;
      break label464;
      label1300:
      localAlertController.Nr.setText(localAlertController.Ns);
      if (localAlertController.Nm != null)
      {
        localAlertController.Nm.setBounds(0, 0, localAlertController.Nb, localAlertController.Nb);
        localAlertController.Nj.setCompoundDrawables(localAlertController.Nm, null, null, null);
      }
      localAlertController.Nr.setVisibility(0);
      i |= 0x4;
      break label520;
      label1373:
      j = 0;
      break label560;
      label1378:
      if (i == 2)
      {
        AlertController.a(localAlertController.Nn);
        break label577;
      }
      if (i != 4) {
        break label577;
      }
      AlertController.a(localAlertController.Nr);
      break label577;
      label1410:
      i = 0;
      break label583;
      label1415:
      localAlertController.me = ((ImageView)localAlertController.Na.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.Cv)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.NG))
        {
          localAlertController.Nx = ((TextView)localAlertController.Na.findViewById(2131820943));
          localAlertController.Nx.setText(localAlertController.Cv);
          if (localAlertController.Nw != 0)
          {
            localAlertController.me.setImageResource(localAlertController.Nw);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.la != null)
          {
            localAlertController.me.setImageDrawable(localAlertController.la);
            break;
          }
          localAlertController.Nx.setPadding(localAlertController.me.getPaddingLeft(), localAlertController.me.getPaddingTop(), localAlertController.me.getPaddingRight(), localAlertController.me.getPaddingBottom());
          localAlertController.me.setVisibility(8);
          break;
        }
      }
      localAlertController.Na.findViewById(2131820942).setVisibility(8);
      localAlertController.me.setVisibility(8);
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
      paramBundle = ((ViewGroup)localObject3).findViewById(2131820936);
      if (paramBundle == null) {
        break label777;
      }
      paramBundle.setVisibility(0);
      break label777;
      label1675:
      m = paramBundle.Op;
      break label823;
      label1684:
      n = paramBundle.Oq;
      break label839;
      label1693:
      paramBundle = localAlertController.Nv;
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
        if (localAlertController.Nc != null)
        {
          localAlertController.Nv.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.Nv.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
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
    AlertController localAlertController = this.Or;
    if ((localAlertController.Nv != null) && (localAlertController.Nv.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.Or;
    if ((localAlertController.Nv != null) && (localAlertController.Nv.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.Or.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a Os;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.n(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.Os = new AlertController.a(new ContextThemeWrapper(paramContext, b.n(paramContext, paramInt)));
      this.mTheme = paramInt;
    }
    
    public final b eA()
    {
      b localb = new b(this.Os.mContext, this.mTheme);
      AlertController.a locala = this.Os;
      AlertController localAlertController = localb.Or;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label294:
      label335:
      label367:
      int i;
      if (locala.Ny != null)
      {
        localAlertController.Ny = locala.Ny;
        if (locala.Nc != null)
        {
          localObject = locala.Nc;
          localAlertController.Nc = ((CharSequence)localObject);
          if (localAlertController.fc != null) {
            localAlertController.fc.setText((CharSequence)localObject);
          }
        }
        if ((locala.NN != null) || (locala.NO != null)) {
          localAlertController.a(-1, locala.NN, locala.NP, null, locala.NO);
        }
        if ((locala.NQ != null) || (locala.NR != null)) {
          localAlertController.a(-2, locala.NQ, locala.NS, null, locala.NR);
        }
        if ((locala.NT != null) || (locala.NU != null)) {
          localAlertController.a(-3, locala.NT, locala.NV, null, locala.NU);
        }
        if ((locala.NZ != null) || (locala.Js != null) || (locala.xw != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.NC, null);
          if (!locala.Oc) {
            break label732;
          }
          if (locala.Js != null) {
            break label704;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.ND, locala.NZ, localRecycleListView);
          localAlertController.xw = ((ListAdapter)localObject);
          localAlertController.Nz = locala.Nz;
          if (locala.Oa == null) {
            break label848;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.Oh != null) {
            localRecycleListView.setOnItemSelectedListener(locala.Oh);
          }
          if (!locala.Od) {
            break label877;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label919;
        }
        if (!locala.Ni) {
          break label894;
        }
        localObject = locala.mView;
        i = locala.Ne;
        int j = locala.Nf;
        int k = locala.Ng;
        int m = locala.Nh;
        localAlertController.mView = ((View)localObject);
        localAlertController.Nd = 0;
        localAlertController.Ni = true;
        localAlertController.Ne = i;
        localAlertController.Nf = j;
        localAlertController.Ng = k;
        localAlertController.Nh = m;
      }
      for (;;)
      {
        localb.setCancelable(this.Os.mCancelable);
        if (this.Os.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.Os.NW);
        localb.setOnDismissListener(this.Os.NX);
        if (this.Os.NY != null) {
          localb.setOnKeyListener(this.Os.NY);
        }
        return localb;
        if (locala.Cv != null) {
          localAlertController.setTitle(locala.Cv);
        }
        if (locala.la != null)
        {
          localObject = locala.la;
          localAlertController.la = ((Drawable)localObject);
          localAlertController.Nw = 0;
          if (localAlertController.me != null)
          {
            if (localObject == null) {
              break label691;
            }
            localAlertController.me.setVisibility(0);
            localAlertController.me.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.Nw != 0) {
            localAlertController.setIcon(locala.Nw);
          }
          if (locala.NM == 0) {
            break;
          }
          i = locala.NM;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label691:
          localAlertController.me.setVisibility(8);
        }
        label704:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.Js, localRecycleListView, localAlertController);
        break label294;
        label732:
        if (locala.Od) {}
        for (i = localAlertController.NE;; i = localAlertController.NF)
        {
          if (locala.Js == null) {
            break label807;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.Js, new String[] { locala.Of }, new int[] { 16908308 });
          break;
        }
        label807:
        if (locala.xw != null)
        {
          localObject = locala.xw;
          break label294;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.NZ);
        break label294;
        label848:
        if (locala.Oe == null) {
          break label335;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label335;
        label877:
        if (!locala.Oc) {
          break label367;
        }
        localRecycleListView.setChoiceMode(2);
        break label367;
        label894:
        localAlertController.mView = locala.mView;
        localAlertController.Nd = 0;
        localAlertController.Ni = false;
        continue;
        label919:
        if (locala.Nd != 0)
        {
          i = locala.Nd;
          localAlertController.mView = null;
          localAlertController.Nd = i;
          localAlertController.Ni = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.7.0.1
 */