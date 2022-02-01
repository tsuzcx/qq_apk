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
  ListAdapter DP;
  CharSequence Eo;
  TextView UA;
  TextView UB;
  View UC;
  int UD = -1;
  int UE;
  int UF;
  int UG;
  int UH;
  int UI;
  int UJ;
  boolean UK;
  int UL = 0;
  final View.OnClickListener UM = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.Uk) && (AlertController.this.Um != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.Um);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        AlertController.this.mHandler.obtainMessage(1, AlertController.this.Ua).sendToTarget();
        return;
        if ((paramAnonymousView == AlertController.this.Uo) && (AlertController.this.Uq != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Uq);
        } else if ((paramAnonymousView == AlertController.this.Us) && (AlertController.this.Uu != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.Uu);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  final e Ua;
  final Window Ub;
  final int Uc;
  CharSequence Ud;
  int Ue;
  int Uf;
  int Ug;
  int Uh;
  int Ui;
  boolean Uj = false;
  Button Uk;
  CharSequence Ul;
  Message Um;
  Drawable Un;
  Button Uo;
  CharSequence Up;
  Message Uq;
  Drawable Ur;
  Button Us;
  CharSequence Ut;
  Message Uu;
  Drawable Uv;
  NestedScrollView Uw;
  int Ux = 0;
  Drawable Uy;
  ImageView Uz;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.mContext = paramContext;
    this.Ua = parame;
    this.Ub = paramWindow;
    this.mHandler = new b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.a.AlertDialog, 2130968643, 0);
    this.UE = paramContext.getResourceId(0, 0);
    this.UF = paramContext.getResourceId(2, 0);
    this.UG = paramContext.getResourceId(4, 0);
    this.UH = paramContext.getResourceId(5, 0);
    this.UI = paramContext.getResourceId(7, 0);
    this.UJ = paramContext.getResourceId(3, 0);
    this.UK = paramContext.getBoolean(6, true);
    this.Uc = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    parame.gl();
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
      this.Ul = paramCharSequence;
      this.Um = paramMessage;
      this.Un = paramDrawable;
      return;
    case -2: 
      this.Up = paramCharSequence;
      this.Uq = paramMessage;
      this.Ur = paramDrawable;
      return;
    }
    this.Ut = paramCharSequence;
    this.Uu = paramMessage;
    this.Uv = paramDrawable;
  }
  
  public final void setIcon(int paramInt)
  {
    this.Uy = null;
    this.Ux = paramInt;
    if (this.Uz != null)
    {
      if (paramInt != 0)
      {
        this.Uz.setVisibility(0);
        this.Uz.setImageResource(this.Ux);
      }
    }
    else {
      return;
    }
    this.Uz.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Eo = paramCharSequence;
    if (this.UA != null) {
      this.UA.setText(paramCharSequence);
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int Vu;
    final int Vv;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RecycleListView);
      this.Vv = paramContext.getDimensionPixelOffset(0, -1);
      this.Vu = paramContext.getDimensionPixelOffset(1, -1);
    }
  }
  
  public static final class a
  {
    public ListAdapter DP;
    public CharSequence Eo;
    public Cursor Qs;
    public View UC;
    public int UD = -1;
    public int UR = 0;
    public CharSequence US;
    public Drawable UT;
    public DialogInterface.OnClickListener UU;
    public CharSequence UV;
    public Drawable UW;
    public DialogInterface.OnClickListener UX;
    public CharSequence UY;
    public Drawable UZ;
    public CharSequence Ud;
    public int Ue;
    public int Uf;
    public int Ug;
    public int Uh;
    public int Ui;
    public boolean Uj = false;
    public int Ux = 0;
    public Drawable Uy;
    public DialogInterface.OnClickListener Va;
    public DialogInterface.OnCancelListener Vb;
    public DialogInterface.OnDismissListener Vc;
    public DialogInterface.OnKeyListener Vd;
    public CharSequence[] Ve;
    public DialogInterface.OnClickListener Vf;
    public boolean[] Vg;
    public boolean Vh;
    public boolean Vi;
    public DialogInterface.OnMultiChoiceClickListener Vj;
    public String Vk;
    public String Vl;
    public AdapterView.OnItemSelectedListener Vm;
    public boolean Vn = true;
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
    private WeakReference<DialogInterface> Vt;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Vt = new WeakReference(paramDialogInterface);
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
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Vt.get(), paramMessage.what);
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