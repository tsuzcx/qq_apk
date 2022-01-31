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

public final class AlertController
{
  CharSequence Cv;
  final e MZ;
  int NA;
  int NB;
  int NC;
  int ND;
  int NE;
  int NF;
  boolean NG;
  int NH = 0;
  final View.OnClickListener NI = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.Nj) && (AlertController.this.Nl != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.Nl);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.MZ).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.Nn) && (AlertController.this.Np != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Np);
        } else if ((paramAnonymousView == AlertController.this.Nr) && (AlertController.this.Nt != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Nt);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final Window Na;
  final int Nb;
  CharSequence Nc;
  int Nd;
  int Ne;
  int Nf;
  int Ng;
  int Nh;
  boolean Ni = false;
  public Button Nj;
  CharSequence Nk;
  Message Nl;
  Drawable Nm;
  public Button Nn;
  CharSequence No;
  Message Np;
  Drawable Nq;
  public Button Nr;
  CharSequence Ns;
  Message Nt;
  Drawable Nu;
  NestedScrollView Nv;
  int Nw = 0;
  TextView Nx;
  View Ny;
  int Nz = -1;
  TextView fc;
  Drawable la;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  ImageView me;
  ListAdapter xw;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.mContext = paramContext;
    this.MZ = parame;
    this.Na = paramWindow;
    this.mHandler = new b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.a.AlertDialog, 2130772216, 0);
    this.NA = paramContext.getResourceId(0, 0);
    this.NB = paramContext.getResourceId(1, 0);
    this.NC = paramContext.getResourceId(2, 0);
    this.ND = paramContext.getResourceId(3, 0);
    this.NE = paramContext.getResourceId(4, 0);
    this.NF = paramContext.getResourceId(5, 0);
    this.NG = paramContext.getBoolean(6, true);
    this.Nb = paramContext.getDimensionPixelSize(7, 0);
    paramContext.recycle();
    parame.eS();
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
  
  static boolean aS(View paramView)
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
      if (aS(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  static ViewGroup c(View paramView1, View paramView2)
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
      this.Nk = paramCharSequence;
      this.Nl = paramMessage;
      this.Nm = paramDrawable;
      return;
    case -2: 
      this.No = paramCharSequence;
      this.Np = paramMessage;
      this.Nq = paramDrawable;
      return;
    }
    this.Ns = paramCharSequence;
    this.Nt = paramMessage;
    this.Nu = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.la = null;
    this.Nw = paramInt;
    if (this.me != null)
    {
      if (paramInt != 0)
      {
        this.me.setVisibility(0);
        this.me.setImageResource(this.Nw);
      }
    }
    else {
      return;
    }
    this.me.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Cv = paramCharSequence;
    if (this.Nx != null) {
      this.Nx.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int Op;
    final int Oq;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecycleListView);
      this.Oq = paramContext.getDimensionPixelOffset(0, -1);
      this.Op = paramContext.getDimensionPixelOffset(1, -1);
    }
  }
  
  public static final class a
  {
    public CharSequence Cv;
    public Cursor Js;
    public int NM = 0;
    public CharSequence NN;
    public Drawable NO;
    public DialogInterface.OnClickListener NP;
    public CharSequence NQ;
    public Drawable NR;
    public DialogInterface.OnClickListener NS;
    public CharSequence NT;
    public Drawable NU;
    public DialogInterface.OnClickListener NV;
    public DialogInterface.OnCancelListener NW;
    public DialogInterface.OnDismissListener NX;
    public DialogInterface.OnKeyListener NY;
    public CharSequence[] NZ;
    public CharSequence Nc;
    public int Nd;
    public int Ne;
    public int Nf;
    public int Ng;
    public int Nh;
    public boolean Ni = false;
    public int Nw = 0;
    public View Ny;
    public int Nz = -1;
    public DialogInterface.OnClickListener Oa;
    public boolean[] Ob;
    public boolean Oc;
    public boolean Od;
    public DialogInterface.OnMultiChoiceClickListener Oe;
    public String Of;
    public String Og;
    public AdapterView.OnItemSelectedListener Oh;
    public boolean Oi = true;
    public Drawable la;
    public boolean mCancelable;
    public final Context mContext;
    public final LayoutInflater mInflater;
    public View mView;
    public ListAdapter xw;
    
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
    private WeakReference<DialogInterface> Oo;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Oo = new WeakReference(paramDialogInterface);
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
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Oo.get(), paramMessage.what);
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