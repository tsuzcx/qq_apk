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
import androidx.core.g.w;
import androidx.core.widget.NestedScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends e
  implements DialogInterface
{
  final AlertController fO;
  
  protected b(Context paramContext, int paramInt)
  {
    super(paramContext, k(paramContext, paramInt));
    AppMethodBeat.i(238009);
    this.fO = new AlertController(getContext(), this, getWindow());
    AppMethodBeat.o(238009);
  }
  
  static int k(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(238011);
    if ((paramInt >>> 24 & 0xFF) > 0)
    {
      AppMethodBeat.o(238011);
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogTheme, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(238011);
    return paramInt;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238017);
    super.onCreate(paramBundle);
    AlertController localAlertController = this.fO;
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
    if ((localAlertController.eS != 0) && (localAlertController.eY == 1))
    {
      i = localAlertController.eS;
      localAlertController.el.setContentView(i);
      paramBundle = localAlertController.em.findViewById(a.f.parentPanel);
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
        localAlertController.em.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label1074;
      }
      Object localObject5 = (FrameLayout)localAlertController.em.findViewById(a.f.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.ev) {
        ((FrameLayout)localObject5).setPadding(localAlertController.er, localAlertController.es, localAlertController.et, localAlertController.eu);
      }
      if (localAlertController.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).pO = 0.0F;
      }
      View localView = ((ViewGroup)localObject1).findViewById(a.f.topPanel);
      localObject5 = ((ViewGroup)localObject1).findViewById(a.f.contentPanel);
      paramBundle = ((ViewGroup)localObject1).findViewById(a.f.buttonPanel);
      localObject4 = AlertController.b(localView, (View)localObject4);
      localObject3 = AlertController.b((View)localObject5, (View)localObject3);
      paramBundle = AlertController.b(paramBundle, (View)localObject2);
      localAlertController.eI = ((NestedScrollView)localAlertController.em.findViewById(a.f.scrollView));
      localAlertController.eI.setFocusable(false);
      localAlertController.eI.setNestedScrollingEnabled(false);
      localAlertController.eN = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (localAlertController.eN != null)
      {
        if (localAlertController.ep == null) {
          break label1084;
        }
        localAlertController.eN.setText(localAlertController.ep);
      }
      i = 0;
      localAlertController.ew = ((Button)paramBundle.findViewById(16908313));
      localAlertController.ew.setOnClickListener(localAlertController.eZ);
      if ((!TextUtils.isEmpty(localAlertController.ex)) || (localAlertController.ez != null)) {
        break label1178;
      }
      localAlertController.ew.setVisibility(8);
      localAlertController.eA = ((Button)paramBundle.findViewById(16908314));
      localAlertController.eA.setOnClickListener(localAlertController.eZ);
      if ((!TextUtils.isEmpty(localAlertController.eB)) || (localAlertController.eD != null)) {
        break label1249;
      }
      localAlertController.eA.setVisibility(8);
      localAlertController.eE = ((Button)paramBundle.findViewById(16908315));
      localAlertController.eE.setOnClickListener(localAlertController.eZ);
      if ((!TextUtils.isEmpty(localAlertController.eF)) || (localAlertController.eH != null)) {
        break label1322;
      }
      localAlertController.eE.setVisibility(8);
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
        AlertController.a(localAlertController.ew);
      }
      if (i == 0) {
        break label1432;
      }
      i = 1;
      if (i == 0) {
        paramBundle.setVisibility(8);
      }
      if (localAlertController.eO == null) {
        break label1437;
      }
      localObject2 = new ViewGroup.LayoutParams(-1, -2);
      ((ViewGroup)localObject4).addView(localAlertController.eO, 0, (ViewGroup.LayoutParams)localObject2);
      localAlertController.em.findViewById(a.f.title_template).setVisibility(8);
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
      if (localAlertController.eI != null) {
        localAlertController.eI.setClipToPadding(true);
      }
      paramBundle = null;
      if ((localAlertController.ep != null) || (localAlertController.mListView != null)) {
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
          localObject1 = localAlertController.em.findViewById(a.f.scrollIndicatorUp);
          localObject2 = localAlertController.em.findViewById(a.f.scrollIndicatorDown);
          if (Build.VERSION.SDK_INT < 23) {
            break label1734;
          }
          w.w(paramBundle, i);
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
      if ((paramBundle != null) && (localAlertController.eP != null))
      {
        paramBundle.setAdapter(localAlertController.eP);
        i = localAlertController.eQ;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      AppMethodBeat.o(238017);
      return;
      i = localAlertController.eR;
      break;
      label1033:
      if (localAlertController.eq != 0)
      {
        paramBundle = LayoutInflater.from(localAlertController.mContext).inflate(localAlertController.eq, (ViewGroup)localObject1, false);
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
      localAlertController.eN.setVisibility(8);
      localAlertController.eI.removeView(localAlertController.eN);
      if (localAlertController.mListView != null)
      {
        localObject2 = (ViewGroup)localAlertController.eI.getParent();
        i = ((ViewGroup)localObject2).indexOfChild(localAlertController.eI);
        ((ViewGroup)localObject2).removeViewAt(i);
        ((ViewGroup)localObject2).addView(localAlertController.mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label365;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label365;
      label1178:
      localAlertController.ew.setText(localAlertController.ex);
      if (localAlertController.ez != null)
      {
        localAlertController.ez.setBounds(0, 0, localAlertController.eo, localAlertController.eo);
        localAlertController.ew.setCompoundDrawables(localAlertController.ez, null, null, null);
      }
      localAlertController.ew.setVisibility(0);
      i = 1;
      break label423;
      label1249:
      localAlertController.eA.setText(localAlertController.eB);
      if (localAlertController.eD != null)
      {
        localAlertController.eD.setBounds(0, 0, localAlertController.eo, localAlertController.eo);
        localAlertController.eA.setCompoundDrawables(localAlertController.eD, null, null, null);
      }
      localAlertController.eA.setVisibility(0);
      i |= 0x2;
      break label479;
      label1322:
      localAlertController.eE.setText(localAlertController.eF);
      if (localAlertController.ez != null)
      {
        localAlertController.ez.setBounds(0, 0, localAlertController.eo, localAlertController.eo);
        localAlertController.ew.setCompoundDrawables(localAlertController.ez, null, null, null);
      }
      localAlertController.eE.setVisibility(0);
      i |= 0x4;
      break label536;
      label1395:
      j = 0;
      break label577;
      label1400:
      if (i == 2)
      {
        AlertController.a(localAlertController.eA);
        break label594;
      }
      if (i != 4) {
        break label594;
      }
      AlertController.a(localAlertController.eE);
      break label594;
      label1432:
      i = 0;
      break label600;
      label1437:
      localAlertController.eL = ((ImageView)localAlertController.em.findViewById(16908294));
      if (!TextUtils.isEmpty(localAlertController.cZ)) {
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (localAlertController.eX))
        {
          localAlertController.eM = ((TextView)localAlertController.em.findViewById(a.f.alertTitle));
          localAlertController.eM.setText(localAlertController.cZ);
          if (localAlertController.eJ != 0)
          {
            localAlertController.eL.setImageResource(localAlertController.eJ);
            break;
            i = 0;
            continue;
          }
          if (localAlertController.eK != null)
          {
            localAlertController.eL.setImageDrawable(localAlertController.eK);
            break;
          }
          localAlertController.eM.setPadding(localAlertController.eL.getPaddingLeft(), localAlertController.eL.getPaddingTop(), localAlertController.eL.getPaddingRight(), localAlertController.eL.getPaddingBottom());
          localAlertController.eL.setVisibility(8);
          break;
        }
      }
      localAlertController.em.findViewById(a.f.title_template).setVisibility(8);
      localAlertController.eL.setVisibility(8);
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
      m = paramBundle.fM;
      break label840;
      label1706:
      n = paramBundle.fN;
      break label856;
      label1715:
      paramBundle = localAlertController.eI;
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
        if (localAlertController.ep != null)
        {
          localAlertController.eI.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          localAlertController.eI.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
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
    AppMethodBeat.i(238019);
    AlertController localAlertController = this.fO;
    if ((localAlertController.eI != null) && (localAlertController.eI.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238019);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(238019);
    return bool;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238020);
    AlertController localAlertController = this.fO;
    if ((localAlertController.eI != null) && (localAlertController.eI.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238020);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(238020);
    return bool;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238014);
    super.setTitle(paramCharSequence);
    this.fO.setTitle(paramCharSequence);
    AppMethodBeat.o(238014);
  }
  
  public static final class a
  {
    public final AlertController.a fP;
    private final int mTheme;
    
    public a(Context paramContext)
    {
      this(paramContext, b.k(paramContext, 0));
      AppMethodBeat.i(238002);
      AppMethodBeat.o(238002);
    }
    
    private a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(238004);
      this.fP = new AlertController.a(new ContextThemeWrapper(paramContext, b.k(paramContext, paramInt)));
      this.mTheme = paramInt;
      AppMethodBeat.o(238004);
    }
    
    public final b aH()
    {
      AppMethodBeat.i(238006);
      b localb = new b(this.fP.mContext, this.mTheme);
      AlertController.a locala = this.fP;
      AlertController localAlertController = localb.fO;
      Object localObject;
      AlertController.RecycleListView localRecycleListView;
      label299:
      label340:
      label372:
      int i;
      if (locala.eO != null)
      {
        localAlertController.eO = locala.eO;
        if (locala.ep != null)
        {
          localObject = locala.ep;
          localAlertController.ep = ((CharSequence)localObject);
          if (localAlertController.eN != null) {
            localAlertController.eN.setText((CharSequence)localObject);
          }
        }
        if ((locala.fi != null) || (locala.fj != null)) {
          localAlertController.a(-1, locala.fi, locala.fk, null, locala.fj);
        }
        if ((locala.fl != null) || (locala.fn != null)) {
          localAlertController.a(-2, locala.fl, locala.fo, null, locala.fn);
        }
        if ((locala.fp != null) || (locala.fq != null)) {
          localAlertController.a(-3, locala.fp, locala.fr, null, locala.fq);
        }
        if ((locala.fv != null) || (locala.fB != null) || (locala.eP != null))
        {
          localRecycleListView = (AlertController.RecycleListView)locala.mInflater.inflate(localAlertController.eT, null);
          if (!locala.fy) {
            break label742;
          }
          if (locala.fB != null) {
            break label714;
          }
          localObject = new AlertController.a.1(locala, locala.mContext, localAlertController.eU, locala.fv, localRecycleListView);
          localAlertController.eP = ((ListAdapter)localObject);
          localAlertController.eQ = locala.eQ;
          if (locala.fw == null) {
            break label858;
          }
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
          if (locala.fE != null) {
            localRecycleListView.setOnItemSelectedListener(locala.fE);
          }
          if (!locala.fz) {
            break label887;
          }
          localRecycleListView.setChoiceMode(1);
          localAlertController.mListView = localRecycleListView;
        }
        if (locala.mView == null) {
          break label929;
        }
        if (!locala.ev) {
          break label904;
        }
        localObject = locala.mView;
        i = locala.er;
        int j = locala.es;
        int k = locala.et;
        int m = locala.eu;
        localAlertController.mView = ((View)localObject);
        localAlertController.eq = 0;
        localAlertController.ev = true;
        localAlertController.er = i;
        localAlertController.es = j;
        localAlertController.et = k;
        localAlertController.eu = m;
      }
      for (;;)
      {
        localb.setCancelable(this.fP.mCancelable);
        if (this.fP.mCancelable) {
          localb.setCanceledOnTouchOutside(true);
        }
        localb.setOnCancelListener(this.fP.fs);
        localb.setOnDismissListener(this.fP.ft);
        if (this.fP.fu != null) {
          localb.setOnKeyListener(this.fP.fu);
        }
        AppMethodBeat.o(238006);
        return localb;
        if (locala.cZ != null) {
          localAlertController.setTitle(locala.cZ);
        }
        if (locala.eK != null)
        {
          localObject = locala.eK;
          localAlertController.eK = ((Drawable)localObject);
          localAlertController.eJ = 0;
          if (localAlertController.eL != null)
          {
            if (localObject == null) {
              break label701;
            }
            localAlertController.eL.setVisibility(0);
            localAlertController.eL.setImageDrawable((Drawable)localObject);
          }
        }
        for (;;)
        {
          if (locala.eJ != 0) {
            localAlertController.setIcon(locala.eJ);
          }
          if (locala.fh == 0) {
            break;
          }
          i = locala.fh;
          localObject = new TypedValue();
          localAlertController.mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.setIcon(((TypedValue)localObject).resourceId);
          break;
          label701:
          localAlertController.eL.setVisibility(8);
        }
        label714:
        localObject = new AlertController.a.2(locala, locala.mContext, locala.fB, localRecycleListView, localAlertController);
        break label299;
        label742:
        if (locala.fz) {}
        for (i = localAlertController.eV;; i = localAlertController.eW)
        {
          if (locala.fB == null) {
            break label817;
          }
          localObject = new SimpleCursorAdapter(locala.mContext, i, locala.fB, new String[] { locala.fC }, new int[] { 16908308 });
          break;
        }
        label817:
        if (locala.eP != null)
        {
          localObject = locala.eP;
          break label299;
        }
        localObject = new AlertController.c(locala.mContext, i, locala.fv);
        break label299;
        label858:
        if (locala.fA == null) {
          break label340;
        }
        localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        break label340;
        label887:
        if (!locala.fy) {
          break label372;
        }
        localRecycleListView.setChoiceMode(2);
        break label372;
        label904:
        localAlertController.mView = locala.mView;
        localAlertController.eq = 0;
        localAlertController.ev = false;
        continue;
        label929:
        if (locala.eq != 0)
        {
          i = locala.eq;
          localAlertController.mView = null;
          localAlertController.eq = i;
          localAlertController.ev = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.b
 * JD-Core Version:    0.7.0.1
 */