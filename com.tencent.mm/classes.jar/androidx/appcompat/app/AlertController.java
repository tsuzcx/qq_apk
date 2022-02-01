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
  Button eA;
  CharSequence eB;
  Message eC;
  Drawable eD;
  Button eE;
  CharSequence eF;
  Message eG;
  Drawable eH;
  NestedScrollView eI;
  int eJ;
  Drawable eK;
  ImageView eL;
  TextView eM;
  TextView eN;
  View eO;
  ListAdapter eP;
  int eQ;
  int eR;
  int eS;
  int eT;
  int eU;
  int eV;
  int eW;
  boolean eX;
  int eY;
  final View.OnClickListener eZ;
  final e el;
  final Window em;
  final int eo;
  CharSequence ep;
  int eq;
  int er;
  int es;
  int et;
  int eu;
  boolean ev;
  Button ew;
  CharSequence ex;
  Message ey;
  Drawable ez;
  final Context mContext;
  Handler mHandler;
  ListView mListView;
  View mView;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    AppMethodBeat.i(237989);
    this.ev = false;
    this.eJ = 0;
    this.eQ = -1;
    this.eY = 0;
    this.eZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(237952);
        if ((paramAnonymousView == AlertController.this.ew) && (AlertController.this.ey != null)) {
          paramAnonymousView = Message.obtain(AlertController.this.ey);
        }
        for (;;)
        {
          if (paramAnonymousView != null) {
            paramAnonymousView.sendToTarget();
          }
          AlertController.this.mHandler.obtainMessage(1, AlertController.this.el).sendToTarget();
          AppMethodBeat.o(237952);
          return;
          if ((paramAnonymousView == AlertController.this.eA) && (AlertController.this.eC != null)) {
            paramAnonymousView = Message.obtain(AlertController.this.eC);
          } else if ((paramAnonymousView == AlertController.this.eE) && (AlertController.this.eG != null)) {
            paramAnonymousView = Message.obtain(AlertController.this.eG);
          } else {
            paramAnonymousView = null;
          }
        }
      }
    };
    this.mContext = paramContext;
    this.el = parame;
    this.em = paramWindow;
    this.mHandler = new AlertController.b(parame);
    paramContext = paramContext.obtainStyledAttributes(null, a.j.AlertDialog, a.a.alertDialogStyle, 0);
    this.eR = paramContext.getResourceId(a.j.AlertDialog_android_layout, 0);
    this.eS = paramContext.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
    this.eT = paramContext.getResourceId(a.j.AlertDialog_listLayout, 0);
    this.eU = paramContext.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
    this.eV = paramContext.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
    this.eW = paramContext.getResourceId(a.j.AlertDialog_listItemLayout, 0);
    this.eX = paramContext.getBoolean(a.j.AlertDialog_showTitle, true);
    this.eo = paramContext.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    parame.bb();
    AppMethodBeat.o(237989);
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int j = 0;
    AppMethodBeat.i(237998);
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
      AppMethodBeat.o(237998);
      return;
      i = 4;
      break;
    }
  }
  
  static void a(Button paramButton)
  {
    AppMethodBeat.i(238000);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(238000);
  }
  
  static ViewGroup b(View paramView1, View paramView2)
  {
    AppMethodBeat.i(237997);
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label90;
      }
    }
    label90:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      paramView1 = (ViewGroup)paramView1;
      AppMethodBeat.o(237997);
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
        AppMethodBeat.o(237997);
        return paramView1;
      }
    }
  }
  
  static boolean d(View paramView)
  {
    AppMethodBeat.i(237992);
    if (paramView.onCheckIsTextEditor())
    {
      AppMethodBeat.o(237992);
      return true;
    }
    if (!(paramView instanceof ViewGroup))
    {
      AppMethodBeat.o(237992);
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
        AppMethodBeat.o(237992);
        return true;
      }
    }
    AppMethodBeat.o(237992);
    return false;
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    AppMethodBeat.i(237995);
    if (paramOnClickListener != null) {
      paramMessage = this.mHandler.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      paramCharSequence = new IllegalArgumentException("Button does not exist");
      AppMethodBeat.o(237995);
      throw paramCharSequence;
    case -1: 
      this.ex = paramCharSequence;
      this.ey = paramMessage;
      this.ez = paramDrawable;
      AppMethodBeat.o(237995);
      return;
    case -2: 
      this.eB = paramCharSequence;
      this.eC = paramMessage;
      this.eD = paramDrawable;
      AppMethodBeat.o(237995);
      return;
    }
    this.eF = paramCharSequence;
    this.eG = paramMessage;
    this.eH = paramDrawable;
    AppMethodBeat.o(237995);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(237996);
    this.eK = null;
    this.eJ = paramInt;
    if (this.eL != null)
    {
      if (paramInt != 0)
      {
        this.eL.setVisibility(0);
        this.eL.setImageResource(this.eJ);
        AppMethodBeat.o(237996);
        return;
      }
      this.eL.setVisibility(8);
    }
    AppMethodBeat.o(237996);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(237994);
    this.cZ = paramCharSequence;
    if (this.eM != null) {
      this.eM.setText(paramCharSequence);
    }
    AppMethodBeat.o(237994);
  }
  
  public static class RecycleListView
    extends ListView
  {
    final int fM;
    final int fN;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(237981);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.RecycleListView);
      this.fN = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
      this.fM = paramContext.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
      AppMethodBeat.o(237981);
    }
  }
  
  public static final class a
  {
    public CharSequence cZ;
    public int eJ;
    public Drawable eK;
    public View eO;
    public ListAdapter eP;
    public int eQ;
    public CharSequence ep;
    public int eq;
    public int er;
    public int es;
    public int et;
    public int eu;
    public boolean ev;
    public DialogInterface.OnMultiChoiceClickListener fA;
    public Cursor fB;
    public String fC;
    public String fD;
    public AdapterView.OnItemSelectedListener fE;
    public boolean fF;
    public int fh;
    public CharSequence fi;
    public Drawable fj;
    public DialogInterface.OnClickListener fk;
    public CharSequence fl;
    public Drawable fn;
    public DialogInterface.OnClickListener fo;
    public CharSequence fp;
    public Drawable fq;
    public DialogInterface.OnClickListener fr;
    public DialogInterface.OnCancelListener fs;
    public DialogInterface.OnDismissListener ft;
    public DialogInterface.OnKeyListener fu;
    public CharSequence[] fv;
    public DialogInterface.OnClickListener fw;
    public boolean[] fx;
    public boolean fy;
    public boolean fz;
    public boolean mCancelable;
    public final Context mContext;
    public final LayoutInflater mInflater;
    public View mView;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(237972);
      this.eJ = 0;
      this.fh = 0;
      this.ev = false;
      this.eQ = -1;
      this.fF = true;
      this.mContext = paramContext;
      this.mCancelable = true;
      this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      AppMethodBeat.o(237972);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.AlertController
 * JD-Core Version:    0.7.0.1
 */