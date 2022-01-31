package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.q;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
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
  extends i
  implements DialogInterface
{
  public final AlertController OD = new AlertController(getContext(), this, getWindow());
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, j(paramContext, paramInt));
  }
  
  static int j(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) > 0) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.OD;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label108:
    label114:
    int j;
    label225:
    label360:
    int k;
    label418:
    label474:
    int m;
    label530:
    label571:
    label588:
    label594:
    int n;
    if ((localAlertController.NN != 0) && (localAlertController.NT == 1))
    {
      i = localAlertController.NN;
      localAlertController.Nj.setContentView(i);
      paramBundle = localAlertController.Nk.findViewById(a.f.parentPanel);
      localObject4 = paramBundle.findViewById(a.f.topPanel);
      localObject3 = paramBundle.findViewById(a.f.contentPanel);
      localObject2 = paramBundle.findViewById(a.f.buttonPanel);
      localObject1 = (ViewGroup)paramBundle.findViewById(a.f.customPanel);
      if (localAlertController.mView == null) {
        break label1022;
      }
      paramBundle = localAlertController.mView;
      if (paramBundle == null) {
        break label1058;
      }
      i = 1;
      if ((i == 0) || (!AlertController.aL(paramBundle))) {
        localAlertController.Nk.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1063;
      }
      Object localObject5 = (FrameLayout)localAlertController.Nk.findViewById(a.f.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.Nt) {
        ((FrameLayout)localObject5).setPadding(localAlertController.Np, localAlertController.Nq, localAlertController.Nr, localAlertController.Ns);
      }
      if (localAlertController.Nn != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).weight = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(a.f.topPanel);
      localObject5 = ((ViewGroup)localObject1).findViewById(a.f.contentPanel);
      paramBundle = ((ViewGroup)localObject1).findViewById(a.f.buttonPanel);
      localObject4 = AlertController.c(localView, (View)localObject4);
      localObject3 = AlertController.c((View)localObject5, (View)localObject3);
      paramBundle = AlertController.c(paramBundle, (View)localObject2);
      localAlertController.NG = ((NestedScrollView)localAlertController.Nk.findViewById(a.f.scrollView));
      localAlertController.NG.setFocusable(false);
      localAlertController.NG.setNestedScrollingEnabled(false);
      localAlertController.ee = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.ee != null)
      {
        if (localAlertController.Nm == null) {
          break label1073;
        }
        localAlertController.ee.setText(localAlertController.Nm);
      }
      i = 0;
      localAlertController.Nu = ((Button)paramBundle.findViewById(16908313));
      localAlertController.Nu.setOnClickListener(localAlertController.NU);
      if ((!TextUtils.isEmpty(localAlertController.Nv)) || (localAlertController.Nx != null)) {
        break label1167;
      }
      localAlertController.Nu.setVisibility(8);
      localAlertController.Ny = ((Button)paramBundle.findViewById(16908314));
      localAlertController.Ny.setOnClickListener(localAlertController.NU);
      if ((!TextUtils.isEmpty(localAlertController.Nz)) || (localAlertController.NB != null)) {
        break label1238;
      }
      localAlertController.Ny.setVisibility(8);
      localAlertController.NC = ((Button)paramBundle.findViewById(16908315));
      localAlertController.NC.setOnClickListener(localAlertController.NU);
      if ((!TextUtils.isEmpty(localAlertController.ND)) || (localAlertController.NF != null)) {
        break label1311;
      }
      localAlertController.NC.setVisibility(8);
      localObject2 = localAlertController.mContext;
      localObject5 = new TypedValue();
      ((Context)localObject2).getTheme().resolveAttribute(a.a.alertDialogCenterButtons, (TypedValue)localObject5, true);
      if (((TypedValue)localObject5).data == 0) {
        break label1384;
      }
      j = 1;
      if (j != 0)
      {
        if (i != 1) {
          break label1389;
        }
        AlertController.a(localAlertController.Nu);
      }
      if (i == 0) {
        break label1421;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.NJ == null) {
        break label1426;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.NJ, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.Nk.findViewById(a.f.title_template).setVisibility(8);
      label653:
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1644;
      }
      i = 1;
      label670:
      if ((localObject4 == null) || (((ViewGroup)localObject4).getVisibility() == 8)) {
        break label1649;
      }
      k = 1;
      label688:
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1655;
      }
      j = 1;
      label703:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(a.f.textSpacerNoButtons);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if (k == 0) {
        break label1660;
      }
      if (localAlertController.NG != null) {
        localAlertController.NG.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.Nm != null) || (localAlertController.Nn != null)) {
        paramBundle = ((ViewGroup)localObject4).findViewById(a.f.titleDividerNoCustom);
      }
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      label788:
      if ((localAlertController.Nn instanceof AlertController.RecycleListView))
      {
        paramBundle = (AlertController.RecycleListView)localAlertController.Nn;
        if ((j == 0) || (k == 0))
        {
          int i1 = paramBundle.getPaddingLeft();
          if (k == 0) {
            break label1686;
          }
          m = paramBundle.getPaddingTop();
          label834:
          int i2 = paramBundle.getPaddingRight();
          if (j == 0) {
            break label1695;
          }
          n = paramBundle.getPaddingBottom();
          label850:
          paramBundle.setPadding(i1, m, i2, n);
        }
      }
      label897:
      if (i == 0)
      {
        if (localAlertController.Nn == null) {
          break label1704;
        }
        paramBundle = localAlertController.Nn;
        label880:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1713;
          }
          i = 1;
          label891:
          if (j == 0) {
            break label1718;
          }
          j = 2;
          i |= j;
          localObject1 = localAlertController.Nk.findViewById(a.f.scrollIndicatorUp);
          localObject2 = localAlertController.Nk.findViewById(a.f.scrollIndicatorDown);
          if (Build.VERSION.SDK_INT < 23) {
            break label1723;
          }
          q.r(paramBundle, i);
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
      paramBundle = localAlertController.Nn;
      if ((paramBundle != null) && (localAlertController.NK != null))
      {
        paramBundle.setAdapter(localAlertController.NK);
        i = localAlertController.NL;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = localAlertController.NM;
      break;
      label1022:
      if (localAlertController.No != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.No, (ViewGroup)localObject1, false);
        break label108;
      }
      paramBundle = null;
      break label108;
      label1058:
      i = 0;
      break label114;
      label1063:
      ((ViewGroup)localObject1).setVisibility(8);
      break label225;
      label1073:
      localAlertController.ee.setVisibility(8);
      localAlertController.NG.removeView(localAlertController.ee);
      if (localAlertController.Nn != null)
      {
        localObject2 = (ViewGroup)localAlertController.NG.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.NG);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.Nn, i, new ViewGroup.LayoutParams(-1, -1));
        break label360;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label360;
      label1167:
      localAlertController.Nu.setText(localAlertController.Nv);
      if (localAlertController.Nx != null)
      {
        localAlertController.Nx.setBounds(0, 0, localAlertController.Nl, localAlertController.Nl);
        localAlertController.Nu.setCompoundDrawables(localAlertController.Nx, null, null, null);
      }
      localAlertController.Nu.setVisibility(0);
      i = 1;
      break label418;
      label1238:
      localAlertController.Ny.setText(localAlertController.Nz);
      if (localAlertController.NB != null)
      {
        localAlertController.NB.setBounds(0, 0, localAlertController.Nl, localAlertController.Nl);
        localAlertController.Ny.setCompoundDrawables(localAlertController.NB, null, null, null);
      }
      localAlertController.Ny.setVisibility(0);
      i |= 0x2;
      break label474;
      label1311:
      localAlertController.NC.setText(localAlertController.ND);
      if (localAlertController.Nx != null)
      {
        localAlertController.Nx.setBounds(0, 0, localAlertController.Nl, localAlertController.Nl);
        localAlertController.Nu.setCompoundDrawables(localAlertController.Nx, null, null, null);
      }
      localAlertController.NC.setVisibility(0);
      i |= 0x4;
      break label530;
      label1384:
      j = 0;
      break label571;
      label1389:
      if (i == 2)
      {
        AlertController.a(localAlertController.Ny);
        break label588;
      }
      if (i != 4) {
        break label588;
      }
      AlertController.a(localAlertController.NC);
      break label588;
      label1421:
      i = 0;
      break label594;
      label1426:
      localAlertController.li = ((ImageView)localAlertController.Nk.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.BM)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.NS))
        {
          localAlertController.NI = ((TextView)localAlertController.Nk.findViewById(a.f.alertTitle));
          localAlertController.NI.setText(localAlertController.BM);
          if (localAlertController.NH != 0)
          {
            localAlertController.li.setImageResource(localAlertController.NH);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.kc != null)
          {
            localAlertController.li.setImageDrawable(localAlertController.kc);
            break;
          }
          localAlertController.NI.setPadding(localAlertController.li.getPaddingLeft(), localAlertController.li.getPaddingTop(), localAlertController.li.getPaddingRight(), localAlertController.li.getPaddingBottom());
          localAlertController.li.setVisibility(8);
          break;
        }
      }
      localAlertController.Nk.findViewById(a.f.title_template).setVisibility(8);
      localAlertController.li.setVisibility(8);
      ((ViewGroup)localObject4).setVisibility(8);
      break label653;
      label1644:
      i = 0;
      break label670;
      label1649:
      k = 0;
      break label688;
      label1655:
      j = 0;
      break label703;
      label1660:
      if (localObject3 == null) {
        break label788;
      }
      paramBundle = ((ViewGroup)localObject3).findViewById(a.f.textSpacerNoTitle);
      if (paramBundle == null) {
        break label788;
      }
      paramBundle.setVisibility(0);
      break label788;
      label1686:
      m = paramBundle.OB;
      break label834;
      label1695:
      n = paramBundle.OC;
      break label850;
      label1704:
      paramBundle = localAlertController.NG;
      break label880;
      label1713:
      i = 0;
      break label891;
      label1718:
      j = 0;
      break label897;
      label1723:
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
        if (localAlertController.Nm != null)
        {
          localAlertController.NG.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.NG.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
        }
        else if (localAlertController.Nn != null)
        {
          localAlertController.Nn.setOnScrollListener(new AlertController.4(localAlertController, paramBundle, (View)localObject1));
          localAlertController.Nn.post(new AlertController.5(localAlertController, paramBundle, (View)localObject1));
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
    AlertController localAlertController = this.OD;
    if ((localAlertController.NG != null) && (localAlertController.NG.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.OD;
    if ((localAlertController.NG != null) && (localAlertController.NG.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.OD.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a OE;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.j(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.OE = new AlertController.a(new ContextThemeWrapper(paramContext, b.j(paramContext, paramInt)));
      this.mTheme = paramInt;
    }
    
    public final b ee()
    {
      b localb = new b(this.OE.mContext, this.mTheme);
      AlertController.a locala = this.OE;
      AlertController localAlertController = localb.OD;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label294:
      label335:
      label367:
      int i;
      if (locala.NJ != null)
      {
        localAlertController.NJ = locala.NJ;
        if (locala.Nm != null)
        {
          localObject = locala.Nm;
          localAlertController.Nm = ((CharSequence)localObject);
          if (localAlertController.ee != null) {
            localAlertController.ee.setText((CharSequence)localObject);
          }
        }
        if ((locala.NZ != null) || (locala.Oa != null)) {
          localAlertController.a(-1, locala.NZ, locala.Ob, null, locala.Oa);
        }
        if ((locala.Oc != null) || (locala.Od != null)) {
          localAlertController.a(-2, locala.Oc, locala.Oe, null, locala.Od);
        }
        if ((locala.Of != null) || (locala.Og != null)) {
          localAlertController.a(-3, locala.Of, locala.Oh, null, locala.Og);
        }
        if ((locala.Ol != null) || (locala.JM != null) || (locala.NK != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.Lu.inflate(localAlertController.NO, null);
          if (!locala.Oo) {
            break label732;
          }
          if (locala.JM != null) {
            break label704;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.NP, locala.Ol, localRecycleListView);
          localAlertController.NK = ((ListAdapter)localObject);
          localAlertController.NL = locala.NL;
          if (locala.Om == null) {
            break label848;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.Ot != null) {
            localRecycleListView.setOnItemSelectedListener(locala.Ot);
          }
          if (!locala.Op) {
            break label877;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.Nn = localRecycleListView;
        }
        if (locala.mView == null) {
          break label919;
        }
        if (!locala.Nt) {
          break label894;
        }
        localObject = locala.mView;
        i = locala.Np;
        int j = locala.Nq;
        int k = locala.Nr;
        int m = locala.Ns;
        localAlertController.mView = ((View)localObject);
        localAlertController.No = 0;
        localAlertController.Nt = true;
        localAlertController.Np = i;
        localAlertController.Nq = j;
        localAlertController.Nr = k;
        localAlertController.Ns = m;
      }
      for (;;)
      {
        localb.setCancelable(this.OE.mCancelable);
        if (this.OE.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.OE.Oi);
        localb.setOnDismissListener(this.OE.Oj);
        if (this.OE.Ok != null) {
          localb.setOnKeyListener(this.OE.Ok);
        }
        return localb;
        if (locala.BM != null) {
          localAlertController.setTitle(locala.BM);
        }
        if (locala.kc != null)
        {
          localObject = locala.kc;
          localAlertController.kc = ((Drawable)localObject);
          localAlertController.NH = 0;
          if (localAlertController.li != null)
          {
            if (localObject == null) {
              break label691;
            }
            localAlertController.li.setVisibility(0);
            localAlertController.li.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.NH != 0) {
            localAlertController.setIcon(locala.NH);
          }
          if (locala.NY == 0) {
            break;
          }
          i = locala.NY;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label691:
          localAlertController.li.setVisibility(8);
        }
        label704:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.JM, localRecycleListView, localAlertController);
        break label294;
        label732:
        if (locala.Op) {}
        for (i = localAlertController.NQ;; i = localAlertController.NR)
        {
          if (locala.JM == null) {
            break label807;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.JM, new String[] { locala.Or }, new int[] { 16908308 });
          break;
        }
        label807:
        if (locala.NK != null)
        {
          localObject = locala.NK;
          break label294;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.Ol);
        break label294;
        label848:
        if (locala.Oq == null) {
          break label335;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label335;
        label877:
        if (!locala.Oo) {
          break label367;
        }
        localRecycleListView.setChoiceMode(2);
        break label367;
        label894:
        localAlertController.mView = locala.mView;
        localAlertController.No = 0;
        localAlertController.Nt = false;
        continue;
        label919:
        if (locala.No != 0)
        {
          i = locala.No;
          localAlertController.mView = null;
          localAlertController.No = i;
          localAlertController.Nt = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.7.0.1
 */