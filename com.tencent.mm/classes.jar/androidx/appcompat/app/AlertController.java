package androidx.appcompat.app;

import android.content.Context;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.j;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlertController
{
  CharSequence cZ;
  Message fA;
  Drawable fB;
  Button fC;
  CharSequence fD;
  Message fE;
  Drawable fF;
  Button fG;
  CharSequence fH;
  Message fI;
  Drawable fJ;
  NestedScrollView fK;
  int fL;
  Drawable fM;
  ImageView fN;
  TextView fO;
  TextView fP;
  View fQ;
  ListAdapter fR;
  int fS;
  int fT;
  int fU;
  int fV;
  int fW;
  int fX;
  int fY;
  boolean fZ;
  final e fn;
  final Window fo;
  final int fp;
  CharSequence fq;
  int fs;
  int ft;
  int fu;
  int fv;
  int fw;
  boolean fx;
  Button fy;
  CharSequence fz;
  int ga;
  final View.OnClickListener gb;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    AppMethodBeat.i(200527);
    this.fx = false;
    this.fL = 0;
    this.fS = -1;
    this.ga = 0;
    this.gb = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200410);
        if ((paramAnonymousView == AlertController.this.fy) && (AlertController.this.fA != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.fA);
        }
        for (;;)
        {
          if (paramAnonymousView != null) {
            paramAnonymousView.sendToTarget();
          }
          AlertController.this.mHandler.obtainMessage(1, AlertController.this.fn).sendToTarget();
          AppMethodBeat.o(200410);
          return;
          if ((paramAnonymousView == AlertController.this.fC) && (AlertController.this.fE != null)) {
            paramAnonymousView = Message.obtain(AlertController.this.fE);
          } else if ((paramAnonymousView == AlertController.this.fG) && (AlertController.this.fI != null)) {
            paramAnonymousView = Message.obtain(AlertController.this.fI);
          } else {
            paramAnonymousView = null;
          }
        }
      }
    };
    this.mContext = paramContext;
    this.fn = parame;
    this.fo = paramWindow;
    this.mHandler = new AlertController.b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.j.AlertDialog, a.a.alertDialogStyle, 0);
    this.fT = paramContext.getResourceId(a.j.AlertDialog_android_layout, 0);
    this.fU = paramContext.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
    this.fV = paramContext.getResourceId(a.j.AlertDialog_listLayout, 0);
    this.fW = paramContext.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
    this.fX = paramContext.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
    this.fY = paramContext.getResourceId(a.j.AlertDialog_listItemLayout, 0);
    this.fZ = paramContext.getBoolean(a.j.AlertDialog_showTitle, true);
    this.fp = paramContext.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    parame.bU();
    AppMethodBeat.o(200527);
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int j = 0;
    AppMethodBeat.i(200555);
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
        break label58;
      }
    }
    label58:
    for (int i = j;; i = 4)
    {
      paramView3.setVisibility(i);
      AppMethodBeat.o(200555);
      return;
      i = 4;
      break;
    }
  }
  
  static void a(Button paramButton)
  {
    AppMethodBeat.i(200570);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(200570);
  }
  
  static ViewGroup b(View paramView1, View paramView2)
  {
    AppMethodBeat.i(200544);
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label90;
      }
    }
    label90:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      paramView1 = (ViewGroup)paramView1;
      AppMethodBeat.o(200544);
      return paramView1;
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
        paramView1 = (ViewGroup)paramView1;
        AppMethodBeat.o(200544);
        return paramView1;
      }
    }
  }
  
  static boolean d(View paramView)
  {
    AppMethodBeat.i(200533);
    if (paramView.onCheckIsTextEditor())
    {
      AppMethodBeat.o(200533);
      return true;
    }
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(200533);
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (d(paramView.getChildAt(j)))
      {
        AppMethodBeat.o(200533);
        return true;
      }
    }
    AppMethodBeat.o(200533);
    return false;
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    AppMethodBeat.i(200590);
    if (paramOnClickListener != null) {
      paramMessage = this.mHandler.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      paramCharSequence = new IllegalArgumentException("Button does not exist");
      AppMethodBeat.o(200590);
      throw paramCharSequence;
    case -1: 
      this.fz = paramCharSequence;
      this.fA = paramMessage;
      this.fB = paramDrawable;
      AppMethodBeat.o(200590);
      return;
    case -2: 
      this.fD = paramCharSequence;
      this.fE = paramMessage;
      this.fF = paramDrawable;
      AppMethodBeat.o(200590);
      return;
    }
    this.fH = paramCharSequence;
    this.fI = paramMessage;
    this.fJ = paramDrawable;
    AppMethodBeat.o(200590);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(200598);
    this.fM = null;
    this.fL = paramInt;
    if (this.fN != null)
    {
      if (paramInt != 0)
      {
        this.fN.setVisibility(0);
        this.fN.setImageResource(this.fL);
        AppMethodBeat.o(200598);
        return;
      }
      this.fN.setVisibility(8);
    }
    AppMethodBeat.o(200598);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200580);
    this.cZ = paramCharSequence;
    if (this.fO != null) {
      this.fO.setText(paramCharSequence);
    }
    AppMethodBeat.o(200580);
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int gH;
    final int gI;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(200436);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.RecycleListView);
      this.gI = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
      this.gH = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
      AppMethodBeat.o(200436);
    }
  }
  
  public static final class a
  {
    public CharSequence cZ;
    public int fL;
    public Drawable fM;
    public View fQ;
    public ListAdapter fR;
    public int fS;
    public CharSequence fq;
    public int fs;
    public int ft;
    public int fu;
    public int fv;
    public int fw;
    public boolean fx;
    public boolean gA;
    public int gf;
    public CharSequence gg;
    public Drawable gh;
    public DialogInterface.OnClickListener gi;
    public CharSequence gj;
    public Drawable gk;
    public DialogInterface.OnClickListener gl;
    public CharSequence gm;
    public Drawable gn;
    public DialogInterface.OnClickListener go;
    public DialogInterface.OnKeyListener gp;
    public CharSequence[] gq;
    public DialogInterface.OnClickListener gr;
    public boolean[] gs;
    public boolean gt;
    public boolean gu;
    public DialogInterface.OnMultiChoiceClickListener gv;
    public Cursor gw;
    public String gx;
    public String gy;
    public AdapterView.OnItemSelectedListener gz;
    public boolean mCancelable;
    public final Context mContext;
    public final LayoutInflater mInflater;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public View mView;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(200635);
      this.fL = 0;
      this.gf = 0;
      this.fx = false;
      this.fS = -1;
      this.gA = true;
      this.mContext = paramContext;
      this.mCancelable = true;
      this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      AppMethodBeat.o(200635);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.AlertController
 * JD-Core Version:    0.7.0.1
 */