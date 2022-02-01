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
  ListAdapter EN;
  CharSequence Fm;
  final e UW;
  final Window UX;
  final int UY;
  CharSequence UZ;
  int VA;
  int VB;
  int VC;
  int VD;
  int VE;
  int VF;
  boolean VG;
  int VH = 0;
  final View.OnClickListener VI = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.Vg) && (AlertController.this.Vi != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.Vi);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.UW).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.Vk) && (AlertController.this.Vm != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Vm);
        } else if ((paramAnonymousView == AlertController.this.Vo) && (AlertController.this.Vq != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Vq);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  int Va;
  int Vb;
  int Vc;
  int Vd;
  int Ve;
  boolean Vf = false;
  Button Vg;
  CharSequence Vh;
  Message Vi;
  Drawable Vj;
  Button Vk;
  CharSequence Vl;
  Message Vm;
  Drawable Vn;
  Button Vo;
  CharSequence Vp;
  Message Vq;
  Drawable Vr;
  NestedScrollView Vs;
  int Vt = 0;
  Drawable Vu;
  ImageView Vv;
  TextView Vw;
  TextView Vx;
  View Vy;
  int Vz = -1;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.mContext = paramContext;
    this.UW = parame;
    this.UX = paramWindow;
    this.mHandler = new b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.a.AlertDialog, 2130968643, 0);
    this.VA = paramContext.getResourceId(0, 0);
    this.VB = paramContext.getResourceId(2, 0);
    this.VC = paramContext.getResourceId(4, 0);
    this.VD = paramContext.getResourceId(5, 0);
    this.VE = paramContext.getResourceId(7, 0);
    this.VF = paramContext.getResourceId(3, 0);
    this.VG = paramContext.getBoolean(6, true);
    this.UY = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    parame.gt();
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
      this.Vh = paramCharSequence;
      this.Vi = paramMessage;
      this.Vj = paramDrawable;
      return;
    case -2: 
      this.Vl = paramCharSequence;
      this.Vm = paramMessage;
      this.Vn = paramDrawable;
      return;
    }
    this.Vp = paramCharSequence;
    this.Vq = paramMessage;
    this.Vr = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.Vu = null;
    this.Vt = paramInt;
    if (this.Vv != null)
    {
      if (paramInt != 0)
      {
        this.Vv.setVisibility(0);
        this.Vv.setImageResource(this.Vt);
      }
    }
    else {
      return;
    }
    this.Vv.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Fm = paramCharSequence;
    if (this.Vw != null) {
      this.Vw.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int Wp;
    final int Wq;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecycleListView);
      this.Wq = paramContext.getDimensionPixelOffset(0, -1);
      this.Wp = paramContext.getDimensionPixelOffset(1, -1);
    }
  }
  
  public static final class a
  {
    public ListAdapter EN;
    public CharSequence Fm;
    public Cursor Rn;
    public CharSequence UZ;
    public int VM = 0;
    public CharSequence VN;
    public Drawable VO;
    public DialogInterface.OnClickListener VP;
    public CharSequence VQ;
    public Drawable VR;
    public DialogInterface.OnClickListener VS;
    public CharSequence VT;
    public Drawable VU;
    public DialogInterface.OnClickListener VV;
    public DialogInterface.OnCancelListener VW;
    public DialogInterface.OnDismissListener VX;
    public DialogInterface.OnKeyListener VY;
    public CharSequence[] VZ;
    public int Va;
    public int Vb;
    public int Vc;
    public int Vd;
    public int Ve;
    public boolean Vf = false;
    public int Vt = 0;
    public Drawable Vu;
    public View Vy;
    public int Vz = -1;
    public DialogInterface.OnClickListener Wa;
    public boolean[] Wb;
    public boolean Wc;
    public boolean Wd;
    public DialogInterface.OnMultiChoiceClickListener We;
    public String Wf;
    public String Wg;
    public AdapterView.OnItemSelectedListener Wh;
    public boolean Wi = true;
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
    private WeakReference<DialogInterface> Wo;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Wo = new WeakReference(paramDialogInterface);
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
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Wo.get(), paramMessage.what);
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