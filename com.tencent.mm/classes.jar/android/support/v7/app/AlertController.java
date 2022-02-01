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
  ListAdapter GO;
  CharSequence Hn;
  final e WY;
  final Window WZ;
  View XA;
  int XB = -1;
  int XC;
  int XD;
  int XE;
  int XF;
  int XG;
  int XH;
  boolean XI;
  int XJ = 0;
  final View.OnClickListener XK = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.Xi) && (AlertController.this.Xk != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.Xk);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.WY).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.Xm) && (AlertController.this.Xo != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Xo);
        } else if ((paramAnonymousView == AlertController.this.Xq) && (AlertController.this.Xs != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Xs);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final int Xa;
  CharSequence Xb;
  int Xc;
  int Xd;
  int Xe;
  int Xf;
  int Xg;
  boolean Xh = false;
  Button Xi;
  CharSequence Xj;
  Message Xk;
  Drawable Xl;
  Button Xm;
  CharSequence Xn;
  Message Xo;
  Drawable Xp;
  Button Xq;
  CharSequence Xr;
  Message Xs;
  Drawable Xt;
  NestedScrollView Xu;
  int Xv = 0;
  Drawable Xw;
  ImageView Xx;
  TextView Xy;
  TextView Xz;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.mContext = paramContext;
    this.WY = parame;
    this.WZ = paramWindow;
    this.mHandler = new b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.a.AlertDialog, 2130968644, 0);
    this.XC = paramContext.getResourceId(0, 0);
    this.XD = paramContext.getResourceId(2, 0);
    this.XE = paramContext.getResourceId(4, 0);
    this.XF = paramContext.getResourceId(5, 0);
    this.XG = paramContext.getResourceId(7, 0);
    this.XH = paramContext.getResourceId(3, 0);
    this.XI = paramContext.getBoolean(6, true);
    this.Xa = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    parame.gR();
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
  
  static boolean aZ(View paramView)
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
      if (aZ(paramView.getChildAt(j))) {
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
      this.Xj = paramCharSequence;
      this.Xk = paramMessage;
      this.Xl = paramDrawable;
      return;
    case -2: 
      this.Xn = paramCharSequence;
      this.Xo = paramMessage;
      this.Xp = paramDrawable;
      return;
    }
    this.Xr = paramCharSequence;
    this.Xs = paramMessage;
    this.Xt = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.Xw = null;
    this.Xv = paramInt;
    if (this.Xx != null)
    {
      if (paramInt != 0)
      {
        this.Xx.setVisibility(0);
        this.Xx.setImageResource(this.Xv);
      }
    }
    else {
      return;
    }
    this.Xx.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Hn = paramCharSequence;
    if (this.Xy != null) {
      this.Xy.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int Yr;
    final int Ys;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecycleListView);
      this.Ys = paramContext.getDimensionPixelOffset(0, -1);
      this.Yr = paramContext.getDimensionPixelOffset(1, -1);
    }
  }
  
  public static final class a
  {
    public ListAdapter GO;
    public CharSequence Hn;
    public Cursor To;
    public View XA;
    public int XB = -1;
    public int XO = 0;
    public CharSequence XP;
    public Drawable XQ;
    public DialogInterface.OnClickListener XR;
    public CharSequence XS;
    public Drawable XT;
    public DialogInterface.OnClickListener XU;
    public CharSequence XV;
    public Drawable XW;
    public DialogInterface.OnClickListener XX;
    public DialogInterface.OnCancelListener XY;
    public DialogInterface.OnDismissListener XZ;
    public CharSequence Xb;
    public int Xc;
    public int Xd;
    public int Xe;
    public int Xf;
    public int Xg;
    public boolean Xh = false;
    public int Xv = 0;
    public Drawable Xw;
    public DialogInterface.OnKeyListener Ya;
    public CharSequence[] Yb;
    public DialogInterface.OnClickListener Yc;
    public boolean[] Yd;
    public boolean Ye;
    public boolean Yf;
    public DialogInterface.OnMultiChoiceClickListener Yg;
    public String Yh;
    public String Yi;
    public AdapterView.OnItemSelectedListener Yj;
    public boolean Yk = true;
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
    private WeakReference<DialogInterface> Yq;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Yq = new WeakReference(paramDialogInterface);
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
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Yq.get(), paramMessage.what);
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