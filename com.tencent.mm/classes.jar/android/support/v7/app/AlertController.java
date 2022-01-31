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
import android.support.v7.a.a.j;
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
  CharSequence BM;
  Message NA;
  Drawable NB;
  public Button NC;
  CharSequence ND;
  Message NE;
  Drawable NF;
  NestedScrollView NG;
  int NH = 0;
  TextView NI;
  View NJ;
  ListAdapter NK;
  int NL = -1;
  int NM;
  int NN;
  int NO;
  int NP;
  int NQ;
  int NR;
  boolean NS;
  int NT = 0;
  final View.OnClickListener NU = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.Nu) && (AlertController.this.Nw != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.Nw);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.Nj).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.Ny) && (AlertController.this.NA != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.NA);
        } else if ((paramAnonymousView == AlertController.this.NC) && (AlertController.this.NE != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.NE);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final i Nj;
  final Window Nk;
  final int Nl;
  CharSequence Nm;
  ListView Nn;
  int No;
  int Np;
  int Nq;
  int Nr;
  int Ns;
  boolean Nt = false;
  public Button Nu;
  CharSequence Nv;
  Message Nw;
  Drawable Nx;
  public Button Ny;
  CharSequence Nz;
  TextView ee;
  Drawable kc;
  ImageView li;
  final Context mContext;
  Handler mHandler;
  View mView;
  
  public AlertController(Context paramContext, i parami, Window paramWindow)
  {
    this.mContext = paramContext;
    this.Nj = parami;
    this.Nk = paramWindow;
    this.mHandler = new b(parami);
    paramContext = paramContext.obtainStyledAttributes(null, a.j.AlertDialog, a.a.alertDialogStyle, 0);
    this.NM = paramContext.getResourceId(a.j.AlertDialog_android_layout, 0);
    this.NN = paramContext.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
    this.NO = paramContext.getResourceId(a.j.AlertDialog_listLayout, 0);
    this.NP = paramContext.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
    this.NQ = paramContext.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
    this.NR = paramContext.getResourceId(a.j.AlertDialog_listItemLayout, 0);
    this.NS = paramContext.getBoolean(a.j.AlertDialog_showTitle, true);
    this.Nl = paramContext.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    parami.et();
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
  
  static boolean aL(View paramView)
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
      if (aL(paramView.getChildAt(j))) {
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
      this.Nv = paramCharSequence;
      this.Nw = paramMessage;
      this.Nx = paramDrawable;
      return;
    case -2: 
      this.Nz = paramCharSequence;
      this.NA = paramMessage;
      this.NB = paramDrawable;
      return;
    }
    this.ND = paramCharSequence;
    this.NE = paramMessage;
    this.NF = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.kc = null;
    this.NH = paramInt;
    if (this.li != null)
    {
      if (paramInt != 0)
      {
        this.li.setVisibility(0);
        this.li.setImageResource(this.NH);
      }
    }
    else {
      return;
    }
    this.li.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    if (this.NI != null) {
      this.NI.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int OB;
    final int OC;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.RecycleListView);
      this.OC = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
      this.OB = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
    }
  }
  
  public static final class a
  {
    public CharSequence BM;
    public Cursor JM;
    public final LayoutInflater Lu;
    public int NH = 0;
    public View NJ;
    public ListAdapter NK;
    public int NL = -1;
    public int NY = 0;
    public CharSequence NZ;
    public CharSequence Nm;
    public int No;
    public int Np;
    public int Nq;
    public int Nr;
    public int Ns;
    public boolean Nt = false;
    public Drawable Oa;
    public DialogInterface.OnClickListener Ob;
    public CharSequence Oc;
    public Drawable Od;
    public DialogInterface.OnClickListener Oe;
    public CharSequence Of;
    public Drawable Og;
    public DialogInterface.OnClickListener Oh;
    public DialogInterface.OnCancelListener Oi;
    public DialogInterface.OnDismissListener Oj;
    public DialogInterface.OnKeyListener Ok;
    public CharSequence[] Ol;
    public DialogInterface.OnClickListener Om;
    public boolean[] On;
    public boolean Oo;
    public boolean Op;
    public DialogInterface.OnMultiChoiceClickListener Oq;
    public String Or;
    public String Os;
    public AdapterView.OnItemSelectedListener Ot;
    public boolean Ou = true;
    public Drawable kc;
    public boolean mCancelable;
    public final Context mContext;
    public View mView;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.mCancelable = true;
      this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  private static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> OA;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.OA = new WeakReference(paramDialogInterface);
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
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.OA.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  private static final class c
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