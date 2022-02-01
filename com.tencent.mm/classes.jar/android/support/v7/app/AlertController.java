package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.b;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

final class AlertController
{
  ListAdapter GE;
  CharSequence Hd;
  final e WL;
  final Window WM;
  final int WN;
  CharSequence WO;
  int WP;
  int WQ;
  int WR;
  int WS;
  int WT;
  boolean WU = false;
  Button WV;
  CharSequence WW;
  Message WX;
  Drawable WY;
  Button WZ;
  CharSequence Xa;
  Message Xb;
  Drawable Xc;
  Button Xd;
  CharSequence Xe;
  Message Xf;
  Drawable Xg;
  NestedScrollView Xh;
  int Xi = 0;
  Drawable Xj;
  ImageView Xk;
  TextView Xl;
  TextView Xm;
  View Xn;
  int Xo = -1;
  int Xp;
  int Xq;
  int Xr;
  int Xs;
  int Xt;
  int Xu;
  boolean Xv;
  int Xw = 0;
  final View.OnClickListener Xx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.WV) && (AlertController.this.WX != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.WX);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.WL).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.WZ) && (AlertController.this.Xb != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Xb);
        } else if ((paramAnonymousView == AlertController.this.Xd) && (AlertController.this.Xf != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Xf);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.mContext = paramContext;
    this.WL = parame;
    this.WM = paramWindow;
    this.mHandler = new b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.a.AlertDialog, 2130968643, 0);
    this.Xp = paramContext.getResourceId(0, 0);
    this.Xq = paramContext.getResourceId(2, 0);
    this.Xr = paramContext.getResourceId(4, 0);
    this.Xs = paramContext.getResourceId(5, 0);
    this.Xt = paramContext.getResourceId(7, 0);
    this.Xu = paramContext.getResourceId(3, 0);
    this.Xv = paramContext.getBoolean(6, true);
    this.WN = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    parame.gK();
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int j = 0;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1))
      {
        i = 0;
        paramView2.setVisibility(i);
      }
    }
    else if (paramView3 != null) {
      if (!paramView1.canScrollVertically(1)) {
        break label48;
      }
    }
    label48:
    for (int i = j;; i = 4)
    {
      paramView3.setVisibility(i);
      return;
      i = 4;
      break;
    }
  }
  
  static void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  static boolean aY(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (aY(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  static ViewGroup d(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    if (paramOnClickListener != null) {
      paramMessage = this.mHandler.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.WW = paramCharSequence;
      this.WX = paramMessage;
      this.WY = paramDrawable;
      return;
    case -2: 
      this.Xa = paramCharSequence;
      this.Xb = paramMessage;
      this.Xc = paramDrawable;
      return;
    }
    this.Xe = paramCharSequence;
    this.Xf = paramMessage;
    this.Xg = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.Xj = null;
    this.Xi = paramInt;
    if (this.Xk != null)
    {
      if (paramInt != 0)
      {
        this.Xk.setVisibility(0);
        this.Xk.setImageResource(this.Xi);
      }
    }
    else {
      return;
    }
    this.Xk.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Hd = paramCharSequence;
    if (this.Xl != null) {
      this.Xl.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int Ye;
    final int Yf;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecycleListView);
      this.Yf = paramContext.getDimensionPixelOffset(0, -1);
      this.Ye = paramContext.getDimensionPixelOffset(1, -1);
    }
  }
  
  public static final class a
  {
    public ListAdapter GE;
    public CharSequence Hd;
    public Cursor Tc;
    public CharSequence WO;
    public int WP;
    public int WQ;
    public int WR;
    public int WS;
    public int WT;
    public boolean WU = false;
    public int XB = 0;
    public CharSequence XC;
    public Drawable XD;
    public DialogInterface.OnClickListener XE;
    public CharSequence XF;
    public Drawable XG;
    public DialogInterface.OnClickListener XH;
    public CharSequence XI;
    public Drawable XJ;
    public DialogInterface.OnClickListener XK;
    public DialogInterface.OnCancelListener XL;
    public DialogInterface.OnDismissListener XM;
    public DialogInterface.OnKeyListener XN;
    public CharSequence[] XO;
    public DialogInterface.OnClickListener XP;
    public boolean[] XQ;
    public boolean XR;
    public boolean XS;
    public DialogInterface.OnMultiChoiceClickListener XT;
    public String XU;
    public String XV;
    public AdapterView.OnItemSelectedListener XW;
    public boolean XX = true;
    public int Xi = 0;
    public Drawable Xj;
    public View Xn;
    public int Xo = -1;
    public boolean mCancelable;
    public final Context mContext;
    public final LayoutInflater mInflater;
    public View mView;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mCancelable = true;
      this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> Yd;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Yd = new WeakReference(paramDialogInterface);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -3: 
      case -2: 
      case -1: 
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Yd.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  static final class c
    extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt, 16908308, paramArrayOfCharSequence);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController
 * JD-Core Version:    0.7.0.1
 */