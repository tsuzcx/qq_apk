package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.b.c;
import com.tencent.mm.plugin.editor.model.nativenote.c.d;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.spans.k;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import com.tencent.mm.plugin.editor.model.nativenote.spans.s;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText
  extends PasterEditText
  implements SpanWatcher
{
  public int acD;
  private av cbR;
  public boolean omD;
  public int omF;
  private c onP;
  private int onQ;
  private int onR;
  private boolean onS;
  private boolean onT;
  private int onU;
  private int onV;
  private String onW;
  public String onX;
  private Spannable onY;
  private int onZ;
  private WXRTEditText ooa;
  public RecyclerView.v oob;
  private boolean ooc;
  private boolean ood;
  private boolean ooe;
  private boolean oof;
  private boolean oog;
  private boolean ooh;
  private boolean ooi;
  private i ooj;
  public boolean ook;
  public boolean ool;
  private int oom;
  private Paint oon;
  private com.tencent.mm.plugin.editor.model.nativenote.c.b ooo;
  private boolean oop;
  private Path ooq;
  private int oor;
  private int oos;
  private int oot;
  private boolean oou;
  TextWatcher oov;
  int oow;
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181787);
    this.onQ = -1;
    this.onR = -1;
    this.onS = false;
    this.onX = "";
    this.onZ = 0;
    this.ooa = null;
    this.acD = 0;
    this.omD = false;
    this.ooh = false;
    this.ook = false;
    this.omF = 0;
    this.ool = false;
    this.oom = -1;
    this.oon = null;
    this.cbR = null;
    this.ooo = null;
    this.oop = false;
    this.ooq = null;
    this.oor = -1;
    this.oos = -1;
    this.oot = -1;
    this.oou = false;
    this.oov = new TextWatcher()
    {
      /* Error */
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 21
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: ldc 29
        //   9: ldc 30
        //   11: invokestatic 36	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   14: aload_1
        //   15: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
        //   18: astore_3
        //   19: aload_0
        //   20: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   23: getfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   26: ifnonnull +347 -> 373
        //   29: ldc 46
        //   31: astore_1
        //   32: aload_0
        //   33: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   36: invokestatic 50	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   39: ifeq +12 -> 51
        //   42: aload_0
        //   43: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   46: ldc 46
        //   48: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   51: aload_0
        //   52: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   55: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   58: ifne +165 -> 223
        //   61: aload_0
        //   62: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   65: invokevirtual 57	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/g;
        //   68: getfield 63	com/tencent/mm/plugin/editor/model/nativenote/manager/g:asw	I
        //   71: aload_0
        //   72: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   75: invokevirtual 57	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/g;
        //   78: getfield 66	com/tencent/mm/plugin/editor/model/nativenote/manager/g:Mc	I
        //   81: if_icmpne +142 -> 223
        //   84: aload_1
        //   85: ldc 68
        //   87: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   90: ifne +29 -> 119
        //   93: new 76	java/lang/StringBuilder
        //   96: dup
        //   97: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   100: aload_1
        //   101: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: ldc 68
        //   106: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   112: aload_3
        //   113: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   116: ifne +29 -> 145
        //   119: aload_1
        //   120: ldc 68
        //   122: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   125: ifeq +98 -> 223
        //   128: aload_1
        //   129: ldc 88
        //   131: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   134: ifne +89 -> 223
        //   137: aload_1
        //   138: aload_3
        //   139: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   142: ifeq +81 -> 223
        //   145: aload_0
        //   146: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   149: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   152: aload_1
        //   153: invokevirtual 96	java/lang/String:length	()I
        //   156: aload_1
        //   157: invokevirtual 96	java/lang/String:length	()I
        //   160: ldc 98
        //   162: invokeinterface 104 4 0
        //   167: checkcast 106	[Landroid/text/style/ParagraphStyle;
        //   170: arraylength
        //   171: ifle +52 -> 223
        //   174: aload_0
        //   175: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   178: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   181: istore_2
        //   182: aload_0
        //   183: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   186: iconst_1
        //   187: invokestatic 113	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   195: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   198: ldc 68
        //   200: invokeinterface 116 2 0
        //   205: pop
        //   206: aload_0
        //   207: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   210: iconst_0
        //   211: invokestatic 113	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Z)Z
        //   214: pop
        //   215: aload_0
        //   216: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   219: iload_2
        //   220: invokevirtual 119	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:setSelection	(I)V
        //   223: aload_0
        //   224: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   227: invokestatic 123	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
        //   230: ifnull +105 -> 335
        //   233: aload_0
        //   234: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   237: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   240: ifne +95 -> 335
        //   243: aload_1
        //   244: aload_3
        //   245: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   248: ifne +87 -> 335
        //   251: aload_0
        //   252: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   255: invokevirtual 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:bSI	()Landroid/text/Spannable;
        //   258: astore_1
        //   259: aload_0
        //   260: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   263: aload_3
        //   264: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   267: aload_0
        //   268: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   271: invokestatic 123	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
        //   274: astore_3
        //   275: aload_0
        //   276: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   279: invokestatic 131	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   282: astore 4
        //   284: aload_0
        //   285: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   288: invokestatic 134	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
        //   291: astore 5
        //   293: aload_0
        //   294: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   297: invokestatic 137	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   300: pop
        //   301: aload_0
        //   302: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   305: invokestatic 140	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   308: pop
        //   309: aload_0
        //   310: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   313: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   316: pop
        //   317: aload_3
        //   318: aload 4
        //   320: aload 5
        //   322: aload_1
        //   323: aload_0
        //   324: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   327: invokevirtual 143	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   330: invokeinterface 148 5 0
        //   335: aload_0
        //   336: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   339: invokestatic 151	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   342: pop
        //   343: aload_0
        //   344: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   347: invokestatic 154	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   350: pop
        //   351: aload_0
        //   352: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   355: invokestatic 157	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:m	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)V
        //   358: aload_0
        //   359: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   362: invokestatic 160	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:n	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)V
        //   365: ldc 21
        //   367: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   370: aload_0
        //   371: monitorexit
        //   372: return
        //   373: aload_0
        //   374: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   377: getfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   380: astore_1
        //   381: goto -349 -> 32
        //   384: astore_1
        //   385: aload_0
        //   386: monitorexit
        //   387: aload_1
        //   388: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	389	0	this	2
        //   0	389	1	paramAnonymousEditable	Editable
        //   181	39	2	i	int
        //   18	300	3	localObject	Object
        //   282	37	4	localWXRTEditText	WXRTEditText
        //   291	30	5	localSpannable	Spannable
        // Exception table:
        //   from	to	target	type
        //   2	29	384	finally
        //   32	51	384	finally
        //   51	119	384	finally
        //   119	145	384	finally
        //   145	223	384	finally
        //   223	335	384	finally
        //   335	370	384	finally
        //   373	381	384	finally
      }
      
      /* Error */
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 166
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_0
        //   8: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   11: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   14: ifnonnull +112 -> 126
        //   17: ldc 46
        //   19: astore 5
        //   21: aload_0
        //   22: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   25: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   28: ifne +90 -> 118
        //   31: aload_1
        //   32: invokeinterface 173 1 0
        //   37: aload 5
        //   39: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   42: ifne +76 -> 118
        //   45: aload_0
        //   46: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   49: aload_0
        //   50: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   53: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   56: invokestatic 176	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;I)I
        //   59: pop
        //   60: aload_0
        //   61: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   64: aload_0
        //   65: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   68: invokevirtual 143	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   71: invokestatic 179	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;I)I
        //   74: pop
        //   75: aload_0
        //   76: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   79: aload_1
        //   80: invokeinterface 173 1 0
        //   85: invokestatic 182	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
        //   88: pop
        //   89: aload_0
        //   90: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   93: aload_0
        //   94: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   97: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   100: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   103: aload_0
        //   104: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   107: aload_0
        //   108: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   111: invokevirtual 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:bSI	()Landroid/text/Spannable;
        //   114: invokestatic 185	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
        //   117: pop
        //   118: ldc 166
        //   120: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   123: aload_0
        //   124: monitorexit
        //   125: return
        //   126: aload_0
        //   127: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   130: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   133: astore 5
        //   135: goto -114 -> 21
        //   138: astore_1
        //   139: aload_0
        //   140: monitorexit
        //   141: aload_1
        //   142: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	143	0	this	2
        //   0	143	1	paramAnonymousCharSequence	CharSequence
        //   0	143	2	paramAnonymousInt1	int
        //   0	143	3	paramAnonymousInt2	int
        //   0	143	4	paramAnonymousInt3	int
        //   19	115	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	17	138	finally
        //   21	118	138	finally
        //   118	123	138	finally
        //   126	135	138	finally
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        try
        {
          AppMethodBeat.i(181784);
          WXRTEditText.e(WXRTEditText.this);
          AppMethodBeat.o(181784);
          return;
        }
        finally
        {
          paramAnonymousCharSequence = finally;
          throw paramAnonymousCharSequence;
        }
      }
    };
    this.oow = 0;
    init();
    AppMethodBeat.o(181787);
  }
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(181788);
    this.onQ = -1;
    this.onR = -1;
    this.onS = false;
    this.onX = "";
    this.onZ = 0;
    this.ooa = null;
    this.acD = 0;
    this.omD = false;
    this.ooh = false;
    this.ook = false;
    this.omF = 0;
    this.ool = false;
    this.oom = -1;
    this.oon = null;
    this.cbR = null;
    this.ooo = null;
    this.oop = false;
    this.ooq = null;
    this.oor = -1;
    this.oos = -1;
    this.oot = -1;
    this.oou = false;
    this.oov = new TextWatcher()
    {
      /* Error */
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 21
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: ldc 29
        //   9: ldc 30
        //   11: invokestatic 36	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   14: aload_1
        //   15: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
        //   18: astore_3
        //   19: aload_0
        //   20: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   23: getfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   26: ifnonnull +347 -> 373
        //   29: ldc 46
        //   31: astore_1
        //   32: aload_0
        //   33: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   36: invokestatic 50	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   39: ifeq +12 -> 51
        //   42: aload_0
        //   43: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   46: ldc 46
        //   48: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   51: aload_0
        //   52: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   55: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   58: ifne +165 -> 223
        //   61: aload_0
        //   62: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   65: invokevirtual 57	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/g;
        //   68: getfield 63	com/tencent/mm/plugin/editor/model/nativenote/manager/g:asw	I
        //   71: aload_0
        //   72: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   75: invokevirtual 57	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/editor/model/nativenote/manager/g;
        //   78: getfield 66	com/tencent/mm/plugin/editor/model/nativenote/manager/g:Mc	I
        //   81: if_icmpne +142 -> 223
        //   84: aload_1
        //   85: ldc 68
        //   87: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   90: ifne +29 -> 119
        //   93: new 76	java/lang/StringBuilder
        //   96: dup
        //   97: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   100: aload_1
        //   101: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   104: ldc 68
        //   106: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   109: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   112: aload_3
        //   113: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   116: ifne +29 -> 145
        //   119: aload_1
        //   120: ldc 68
        //   122: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   125: ifeq +98 -> 223
        //   128: aload_1
        //   129: ldc 88
        //   131: invokevirtual 74	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   134: ifne +89 -> 223
        //   137: aload_1
        //   138: aload_3
        //   139: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   142: ifeq +81 -> 223
        //   145: aload_0
        //   146: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   149: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   152: aload_1
        //   153: invokevirtual 96	java/lang/String:length	()I
        //   156: aload_1
        //   157: invokevirtual 96	java/lang/String:length	()I
        //   160: ldc 98
        //   162: invokeinterface 104 4 0
        //   167: checkcast 106	[Landroid/text/style/ParagraphStyle;
        //   170: arraylength
        //   171: ifle +52 -> 223
        //   174: aload_0
        //   175: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   178: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   181: istore_2
        //   182: aload_0
        //   183: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   186: iconst_1
        //   187: invokestatic 113	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Z)Z
        //   190: pop
        //   191: aload_0
        //   192: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   195: invokevirtual 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   198: ldc 68
        //   200: invokeinterface 116 2 0
        //   205: pop
        //   206: aload_0
        //   207: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   210: iconst_0
        //   211: invokestatic 113	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Z)Z
        //   214: pop
        //   215: aload_0
        //   216: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   219: iload_2
        //   220: invokevirtual 119	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:setSelection	(I)V
        //   223: aload_0
        //   224: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   227: invokestatic 123	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
        //   230: ifnull +105 -> 335
        //   233: aload_0
        //   234: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   237: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   240: ifne +95 -> 335
        //   243: aload_1
        //   244: aload_3
        //   245: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   248: ifne +87 -> 335
        //   251: aload_0
        //   252: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   255: invokevirtual 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:bSI	()Landroid/text/Spannable;
        //   258: astore_1
        //   259: aload_0
        //   260: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   263: aload_3
        //   264: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   267: aload_0
        //   268: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   271: invokestatic 123	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
        //   274: astore_3
        //   275: aload_0
        //   276: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   279: invokestatic 131	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   282: astore 4
        //   284: aload_0
        //   285: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   288: invokestatic 134	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
        //   291: astore 5
        //   293: aload_0
        //   294: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   297: invokestatic 137	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   300: pop
        //   301: aload_0
        //   302: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   305: invokestatic 140	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)I
        //   308: pop
        //   309: aload_0
        //   310: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   313: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   316: pop
        //   317: aload_3
        //   318: aload 4
        //   320: aload 5
        //   322: aload_1
        //   323: aload_0
        //   324: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   327: invokevirtual 143	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   330: invokeinterface 148 5 0
        //   335: aload_0
        //   336: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   339: invokestatic 151	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   342: pop
        //   343: aload_0
        //   344: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   347: invokestatic 154	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   350: pop
        //   351: aload_0
        //   352: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   355: invokestatic 157	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:m	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)V
        //   358: aload_0
        //   359: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   362: invokestatic 160	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:n	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)V
        //   365: ldc 21
        //   367: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   370: aload_0
        //   371: monitorexit
        //   372: return
        //   373: aload_0
        //   374: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   377: getfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   380: astore_1
        //   381: goto -349 -> 32
        //   384: astore_1
        //   385: aload_0
        //   386: monitorexit
        //   387: aload_1
        //   388: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	389	0	this	2
        //   0	389	1	paramAnonymousEditable	Editable
        //   181	39	2	i	int
        //   18	300	3	localObject	Object
        //   282	37	4	localWXRTEditText	WXRTEditText
        //   291	30	5	localSpannable	Spannable
        // Exception table:
        //   from	to	target	type
        //   2	29	384	finally
        //   32	51	384	finally
        //   51	119	384	finally
        //   119	145	384	finally
        //   145	223	384	finally
        //   223	335	384	finally
        //   335	370	384	finally
        //   373	381	384	finally
      }
      
      /* Error */
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 166
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_0
        //   8: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   11: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   14: ifnonnull +112 -> 126
        //   17: ldc 46
        //   19: astore 5
        //   21: aload_0
        //   22: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   25: invokestatic 53	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Z
        //   28: ifne +90 -> 118
        //   31: aload_1
        //   32: invokeinterface 173 1 0
        //   37: aload 5
        //   39: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   42: ifne +76 -> 118
        //   45: aload_0
        //   46: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   49: aload_0
        //   50: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   53: invokevirtual 109	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   56: invokestatic 176	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;I)I
        //   59: pop
        //   60: aload_0
        //   61: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   64: aload_0
        //   65: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   68: invokevirtual 143	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   71: invokestatic 179	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;I)I
        //   74: pop
        //   75: aload_0
        //   76: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   79: aload_1
        //   80: invokeinterface 173 1 0
        //   85: invokestatic 182	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
        //   88: pop
        //   89: aload_0
        //   90: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   93: aload_0
        //   94: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   97: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   100: putfield 44	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onX	Ljava/lang/String;
        //   103: aload_0
        //   104: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   107: aload_0
        //   108: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   111: invokevirtual 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:bSI	()Landroid/text/Spannable;
        //   114: invokestatic 185	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
        //   117: pop
        //   118: ldc 166
        //   120: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   123: aload_0
        //   124: monitorexit
        //   125: return
        //   126: aload_0
        //   127: getfield 14	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText$2:oox	Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;
        //   130: invokestatic 170	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   133: astore 5
        //   135: goto -114 -> 21
        //   138: astore_1
        //   139: aload_0
        //   140: monitorexit
        //   141: aload_1
        //   142: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	143	0	this	2
        //   0	143	1	paramAnonymousCharSequence	CharSequence
        //   0	143	2	paramAnonymousInt1	int
        //   0	143	3	paramAnonymousInt2	int
        //   0	143	4	paramAnonymousInt3	int
        //   19	115	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	17	138	finally
        //   21	118	138	finally
        //   118	123	138	finally
        //   126	135	138	finally
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        try
        {
          AppMethodBeat.i(181784);
          WXRTEditText.e(WXRTEditText.this);
          AppMethodBeat.o(181784);
          return;
        }
        finally
        {
          paramAnonymousCharSequence = finally;
          throw paramAnonymousCharSequence;
        }
      }
    };
    this.oow = 0;
    init();
    AppMethodBeat.o(181788);
  }
  
  private void b(Spannable paramSpannable)
  {
    AppMethodBeat.i(181806);
    int i = getSelectionStart();
    com.tencent.mm.cg.g localg = com.tencent.mm.cg.g.eIa();
    getContext();
    setSpannableText(localg.b(paramSpannable, getTextSize()));
    int j = getText().length() - paramSpannable.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(181806);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(181806);
  }
  
  private void bSN()
  {
    AppMethodBeat.i(181811);
    Editable localEditable = getText();
    if (localEditable.getSpans(0, localEditable.length(), getClass()) != null) {
      localEditable.setSpan(this, 0, localEditable.length(), 18);
    }
    AppMethodBeat.o(181811);
  }
  
  private void bSO()
  {
    AppMethodBeat.i(181819);
    if (this.cbR == null)
    {
      this.cbR = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(181786);
          if ((WXRTEditText.o(WXRTEditText.this) != null) && (WXRTEditText.o(WXRTEditText.this).getType() == 1))
          {
            int i = WXRTEditText.o(WXRTEditText.this).ooZ;
            WXRTEditText.p(WXRTEditText.this);
            WXRTEditText.this.Z(i, false);
          }
          AppMethodBeat.o(181786);
          return true;
        }
      }, false);
      AppMethodBeat.o(181819);
      return;
    }
    this.cbR.stopTimer();
    AppMethodBeat.o(181819);
  }
  
  private void bSP()
  {
    AppMethodBeat.i(181821);
    if (this.ooo == null)
    {
      this.ooo = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
      AppMethodBeat.o(181821);
      return;
    }
    this.ooo.reset();
    AppMethodBeat.o(181821);
  }
  
  private void fb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181822);
    if (this.onZ == 2)
    {
      e.bSW().A(this.oom, 1, this.oom, 1);
      AppMethodBeat.o(181822);
      return;
    }
    if (this.onZ == 1)
    {
      e.bSW().A(this.oom, 0, this.oom, 0);
      AppMethodBeat.o(181822);
      return;
    }
    e locale = e.bSW();
    int i = this.oom;
    locale.A(i, paramInt1, i, paramInt2);
    AppMethodBeat.o(181822);
  }
  
  private i getRTLayout()
  {
    AppMethodBeat.i(181814);
    try
    {
      if ((this.ooj == null) || (this.ooi))
      {
        this.ooj = new i(getText());
        this.ooi = false;
      }
      i locali = this.ooj;
      return locali;
    }
    finally
    {
      AppMethodBeat.o(181814);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(181790);
    this.ooa = this;
    removeTextChangedListener(this.oov);
    addTextChangedListener(this.oov);
    setMovementMethod(com.tencent.mm.plugin.editor.model.nativenote.spans.f.bTz());
    this.oom = -1;
    this.oon = new Paint(1);
    this.oon.setColor(1347529272);
    this.ooo = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
    this.ooq = new Path();
    this.oor = -1;
    this.oos = -1;
    this.oot = -1;
    if (e.isEnabled())
    {
      setHighlightColor(0);
      setCustomSelectionActionModeCallback(new ActionMode.Callback()
      {
        public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
        {
          return false;
        }
        
        public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return false;
        }
        
        public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
        
        public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return false;
        }
      });
    }
    AppMethodBeat.o(181790);
  }
  
  private void setParagraphsAreUp2Date(boolean paramBoolean)
  {
    try
    {
      if (!this.oog) {
        this.oof = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(181820);
    Editable localEditable = getText();
    if (localEditable == null)
    {
      AppMethodBeat.o(181820);
      return;
    }
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(181820);
      return;
    }
    int k = localEditable.length();
    if ((paramInt < 0) || (paramInt > k))
    {
      AppMethodBeat.o(181820);
      return;
    }
    int i;
    if (k == 0)
    {
      paramInt = 0;
      i = 0;
    }
    for (;;)
    {
      if ((i < 0) || (i > k) || (paramInt < 0) || (paramInt > k))
      {
        AppMethodBeat.o(181820);
        return;
        if (paramInt < k)
        {
          if ((paramBoolean) || (localEditable.charAt(paramInt) != '\n'))
          {
            j = localLayout.getOffsetToRightOf(paramInt);
            i = paramInt;
            paramInt = j;
          }
        }
        else if ((paramInt == k) && (paramBoolean)) {
          i = localLayout.getOffsetToLeftOf(paramInt);
        }
      }
      else
      {
        if (e.bSW().isEditable())
        {
          requestFocus();
          setIgnoreSelectChangeByMultiSelect(true);
          setSelection(i, paramInt);
          setIgnoreSelectChangeByMultiSelect(false);
          if (this.onP != null)
          {
            this.onP.e(true, 50L);
            this.onP.zZ(1);
          }
        }
        fb(i, paramInt);
        e.bSW().H(true, true);
        AppMethodBeat.o(181820);
        return;
      }
      i = paramInt;
      int j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public final String a(h paramh)
  {
    AppMethodBeat.i(181803);
    if (paramh == h.ooz)
    {
      paramh = getText().toString();
      AppMethodBeat.o(181803);
      return paramh;
    }
    if (paramh == h.ooA)
    {
      paramh = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(getText());
      AppMethodBeat.o(181803);
      return paramh;
    }
    AppMethodBeat.o(181803);
    return "";
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(181791);
    if (this.onZ == 0) {
      setTextSize(0, com.tencent.mm.cd.a.ao(getContext(), 2131165517));
    }
    f.setTextSize(getTextSize());
    this.onP = paramc;
    AppMethodBeat.o(181791);
  }
  
  public final <V, C extends com.tencent.mm.plugin.editor.model.nativenote.spans.h<V>> void a(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(181810);
    if ((!this.ooh) && (!this.ooe))
    {
      if (this.onT) {}
      for (Spannable localSpannable = null;; localSpannable = bSI())
      {
        paramt.a(this, paramV);
        try
        {
          if ((this.onP != null) && (!this.onT))
          {
            paramt = bSI();
            paramV = this.onP;
            getSelectionStart();
            getSelectionEnd();
            getSelectionStart();
            paramV.a(this, localSpannable, paramt, getSelectionEnd());
          }
          this.ooi = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(181810);
        }
      }
    }
    AppMethodBeat.o(181810);
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(181796);
    if (this.onP != null)
    {
      this.onP.e(true, 50L);
      this.onP.zZ(1);
    }
    AppMethodBeat.o(181796);
  }
  
  public final Spannable bSI()
  {
    AppMethodBeat.i(181800);
    Object localObject = super.getText();
    if (localObject != null) {}
    for (;;)
    {
      localObject = new a((CharSequence)localObject);
      AppMethodBeat.o(181800);
      return localObject;
      localObject = "";
    }
  }
  
  public final void bSJ()
  {
    try
    {
      this.onT = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bSK()
  {
    try
    {
      this.onT = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bSL()
  {
    try
    {
      this.onS = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bSM()
  {
    try
    {
      this.onS = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181797);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(181797);
    return bool;
  }
  
  public k[] getCurrentEditorCursorNumberSpan()
  {
    AppMethodBeat.i(181816);
    Object localObject = getParagraphsInSelection();
    localObject = (k[])getText().getSpans(((g)localObject).asw, ((g)localObject).Mc, k.class);
    AppMethodBeat.o(181816);
    return localObject;
  }
  
  public String getCurrentEditorCursorParagraphStr()
  {
    AppMethodBeat.i(181815);
    Object localObject = getParagraphsInSelection();
    localObject = getText().subSequence(((g)localObject).asw, ((g)localObject).Mc).toString().trim();
    AppMethodBeat.o(181815);
    return localObject;
  }
  
  public int getEditTextType()
  {
    return this.onZ;
  }
  
  public ArrayList<l> getParagraphs()
  {
    AppMethodBeat.i(181813);
    ArrayList localArrayList = getRTLayout().ooD;
    AppMethodBeat.o(181813);
    return localArrayList;
  }
  
  public g getParagraphsInSelection()
  {
    int k = 0;
    AppMethodBeat.i(181812);
    Object localObject = getRTLayout();
    g localg = new g(this);
    int j = ((i)localObject).getLineForOffset(localg.asw);
    int i;
    int m;
    if (localg.isEmpty())
    {
      i = localg.Mc;
      m = ((i)localObject).getLineForOffset(i);
      if ((((i)localObject).ooC != 0) && (j >= 0)) {
        break label119;
      }
      i = 0;
      label71:
      j = k;
      if (((i)localObject).ooC != 0)
      {
        if (m >= 0) {
          break label174;
        }
        j = k;
      }
    }
    for (;;)
    {
      localObject = new g(i, j);
      AppMethodBeat.o(181812);
      return localObject;
      i = localg.Mc - 1;
      break;
      label119:
      if (j < ((i)localObject).ooC)
      {
        i = ((l)((i)localObject).ooD.get(j)).asw;
        break label71;
      }
      i = ((l)((i)localObject).ooD.get(((i)localObject).ooC - 1)).Mc - 1;
      break label71;
      label174:
      if (m < ((i)localObject).ooC) {
        j = ((l)((i)localObject).ooD.get(m)).Mc;
      } else {
        j = ((l)((i)localObject).ooD.get(((i)localObject).ooC - 1)).Mc - 1;
      }
    }
  }
  
  public int getPosInDataList()
  {
    return this.oom;
  }
  
  public int getRecyclerItemPosition()
  {
    AppMethodBeat.i(181804);
    if (this.oob.lm() == -1)
    {
      AppMethodBeat.o(181804);
      return 0;
    }
    int i = this.oob.lm();
    AppMethodBeat.o(181804);
    return i;
  }
  
  public String getSelectedText()
  {
    AppMethodBeat.i(181801);
    Object localObject = getText();
    g localg = getSelection();
    if ((localg.asw >= 0) && (localg.Mc >= 0) && (localg.Mc <= ((Spannable)localObject).length()))
    {
      localObject = ((Spannable)localObject).subSequence(localg.asw, localg.Mc).toString();
      AppMethodBeat.o(181801);
      return localObject;
    }
    AppMethodBeat.o(181801);
    return null;
  }
  
  public g getSelection()
  {
    AppMethodBeat.i(181802);
    g localg = new g(getSelectionStart(), getSelectionEnd());
    AppMethodBeat.o(181802);
    return localg;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(181817);
    Object localObject;
    d locald;
    int j;
    int m;
    int k;
    int i;
    if ((e.isEnabled()) && (this.onZ == 0))
    {
      localObject = getText();
      if (localObject != null)
      {
        locald = e.bSW().bSY();
        j = -1;
        m = 0;
        switch (e.bSW().Af(this.oom))
        {
        default: 
          k = 0;
          i = 0;
          if ((j >= 0) && (i <= ((Editable)localObject).length()) && (j <= i)) {
            break;
          }
        }
      }
    }
    do
    {
      do
      {
        super.onDraw(paramCanvas);
        AppMethodBeat.o(181817);
        return;
      } while (locald.startOffset == locald.opi);
      j = locald.startOffset;
      i = locald.opi;
      k = 0;
      break;
      j = 0;
      i = ((Editable)localObject).length();
      m = 1;
      k = 1;
      break;
      j = locald.startOffset;
      i = ((Editable)localObject).length();
      m = 1;
      k = 0;
      break;
      j = 0;
      i = locald.opi;
      k = 1;
      break;
      localObject = getLayout();
    } while (localObject == null);
    if (this.oor == -1) {
      this.oor = getPaddingLeft();
    }
    if (this.oos == -1) {
      this.oos = getPaddingTop();
    }
    if (this.oot == -1) {
      this.oot = getPaddingBottom();
    }
    if (this.ooq == null) {
      this.ooq = new Path();
    }
    this.ooq.reset();
    label544:
    label832:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      try
      {
        n = ((Layout)localObject).getLineForOffset(j);
        i1 = ((Layout)localObject).getLineForOffset(i);
        if (n > i1) {
          break;
        }
        i2 = ((Layout)localObject).getWidth();
        f1 = ((Layout)localObject).getPrimaryHorizontal(j) + this.oor;
        f2 = ((Layout)localObject).getLineTop(n) + this.oos;
        f3 = ((Layout)localObject).getLineBottom(n) + this.oos;
        f4 = ((Layout)localObject).getPrimaryHorizontal(i) + this.oor;
        f5 = ((Layout)localObject).getLineTop(i1) + this.oos;
        f6 = ((Layout)localObject).getLineBottom(i1) + this.oos;
        if ((k == 0) || (m == 0)) {
          break label544;
        }
        this.ooq.addRect(this.oor, 0.0F, this.oor + i2, f6 + this.oot, Path.Direction.CW);
        if (this.ooq.isEmpty()) {
          break;
        }
        if (this.oon == null)
        {
          this.oon = new Paint(1);
          this.oon.setColor(1347529272);
        }
        paramCanvas.drawPath(this.ooq, this.oon);
      }
      catch (Exception localException)
      {
        ad.e("noteeditor.WXRTEditText", "tryDrawCover: ", new Object[] { localException });
      }
      break;
      if (n == i1)
      {
        if (k != 0) {
          this.ooq.addRect(this.oor, 0.0F, f4, f6, Path.Direction.CW);
        } else if (m != 0) {
          this.ooq.addRect(f1, f2, this.oor + i2, f6 + this.oot, Path.Direction.CW);
        } else {
          this.ooq.addRect(f1, f2, f4, f6, Path.Direction.CW);
        }
      }
      else
      {
        if (k != 0)
        {
          this.ooq.addRect(this.oor, 0.0F, this.oor + i2, f3, Path.Direction.CW);
          this.ooq.addRect(this.oor, f5, f4, f6, Path.Direction.CW);
        }
        for (;;)
        {
          if (i1 - n <= 1) {
            break label832;
          }
          this.ooq.addRect(this.oor, f3, this.oor + i2, f5, Path.Direction.CW);
          break;
          if (m != 0)
          {
            this.ooq.addRect(f1, f2, this.oor + i2, f3, Path.Direction.CW);
            this.ooq.addRect(this.oor, f5, this.oor + i2, f6 + this.oot, Path.Direction.CW);
          }
          else
          {
            this.ooq.addRect(f1, f2, this.oor + i2, f3, Path.Direction.CW);
            this.ooq.addRect(this.oor, f5, f4, f6, Path.Direction.CW);
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(181798);
    this.oou = false;
    this.onQ = -1;
    this.onR = -1;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (this.onP != null) {
      this.onP.a(this, paramBoolean, getRecyclerItemPosition());
    }
    if ((paramBoolean) && (!this.oou)) {
      onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }
    AppMethodBeat.o(181798);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181799);
    try
    {
      if (this.onS) {
        return;
      }
      this.oou = true;
      if (paramInt1 < 0)
      {
        AppMethodBeat.o(181799);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(181799);
    }
    if ((this.onQ != paramInt1) || (this.onR != paramInt2))
    {
      this.onQ = paramInt1;
      this.onR = paramInt2;
      super.onSelectionChanged(paramInt1, paramInt2);
      if (paramInt2 <= paramInt1) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      this.ood = bool;
      if ((!this.ooe) && (!this.oof))
      {
        this.oog = true;
        u.a(this, new t[0]);
        this.oog = false;
        setParagraphsAreUp2Date(true);
      }
      if (this.onP != null)
      {
        this.ooh = true;
        this.onP.a(this, paramInt1, paramInt2);
        this.ooh = false;
      }
      if ((e.isEnabled()) && (!this.oop) && (hasFocus()) && (this.oom >= 0))
      {
        fb(paramInt1, paramInt2);
        if (e.bSW().Af(this.oom) == 1)
        {
          e locale = e.bSW();
          if (e.mHasInit)
          {
            locale.f(true, 0L);
            locale.bTf();
            locale.bTd();
          }
        }
      }
      AppMethodBeat.o(181799);
      return;
    }
  }
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181807);
    this.ooc = true;
    if (((paramObject instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.h)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(181807);
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181809);
    this.ooc = true;
    if (((paramObject instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.h)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(181809);
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181808);
    this.ooc = true;
    if (((paramObject instanceof com.tencent.mm.plugin.editor.model.nativenote.spans.h)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(181808);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 675
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: ldc_w 676
    //   10: if_icmpne +20 -> 30
    //   13: aload_0
    //   14: getfield 259	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onP	Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
    //   17: invokeinterface 679 1 0
    //   22: ldc_w 675
    //   25: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_1
    //   29: ireturn
    //   30: iload_1
    //   31: ldc_w 680
    //   34: if_icmpeq +10 -> 44
    //   37: iload_1
    //   38: ldc_w 681
    //   41: if_icmpne +91 -> 132
    //   44: invokestatic 686	com/tencent/mm/plugin/editor/model/nativenote/manager/b:clearData	()V
    //   47: aload_0
    //   48: iload_1
    //   49: invokespecial 688	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   52: istore_3
    //   53: iload_1
    //   54: ldc_w 689
    //   57: if_icmpne +20 -> 77
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:oow	I
    //   65: aload_0
    //   66: invokevirtual 186	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   69: astore 4
    //   71: aload_0
    //   72: aload 4
    //   74: invokespecial 691	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   77: iload_1
    //   78: ldc_w 689
    //   81: if_icmpne +43 -> 124
    //   84: aload_0
    //   85: getfield 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:omD	Z
    //   88: ifeq +36 -> 124
    //   91: aload_0
    //   92: getfield 259	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onP	Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
    //   95: ifnull +24 -> 119
    //   98: aload_0
    //   99: getfield 259	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onP	Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
    //   102: iconst_0
    //   103: lconst_0
    //   104: invokeinterface 373 4 0
    //   109: aload_0
    //   110: getfield 259	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onP	Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
    //   113: iconst_0
    //   114: invokeinterface 376 2 0
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 92	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:omD	Z
    //   124: ldc_w 675
    //   127: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iload_3
    //   131: ireturn
    //   132: iload_1
    //   133: ldc_w 689
    //   136: if_icmpne -89 -> 47
    //   139: aload_0
    //   140: invokevirtual 171	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:getContext	()Landroid/content/Context;
    //   143: pop
    //   144: invokestatic 694	com/tencent/mm/plugin/editor/model/nativenote/manager/b:bSp	()I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_2
    //   150: if_icmpne +9 -> 159
    //   153: invokestatic 686	com/tencent/mm/plugin/editor/model/nativenote/manager/b:clearData	()V
    //   156: goto -109 -> 47
    //   159: iload_2
    //   160: iconst_3
    //   161: if_icmpne -114 -> 47
    //   164: aload_0
    //   165: getfield 259	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:onP	Lcom/tencent/mm/plugin/editor/model/nativenote/b/c;
    //   168: aload_0
    //   169: invokeinterface 696 2 0
    //   174: ldc_w 675
    //   177: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore 4
    //   184: ldc_w 610
    //   187: ldc_w 698
    //   190: iconst_1
    //   191: anewarray 201	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 4
    //   198: aastore
    //   199: invokestatic 617	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: ldc_w 675
    //   205: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore 5
    //   212: ldc_w 610
    //   215: ldc_w 700
    //   218: iconst_1
    //   219: anewarray 201	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: getfield 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:oow	I
    //   228: invokestatic 706	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 617	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_0
    //   236: getfield 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:oow	I
    //   239: iconst_3
    //   240: if_icmpge +45 -> 285
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:oow	I
    //   248: iconst_1
    //   249: iadd
    //   250: putfield 127	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:oow	I
    //   253: aload_0
    //   254: new 708	android/text/SpannableStringBuilder
    //   257: dup
    //   258: iconst_2
    //   259: anewarray 488	java/lang/CharSequence
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 710
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: aastore
    //   273: invokestatic 716	android/text/TextUtils:concat	([Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   276: invokespecial 717	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   279: invokespecial 691	com/tencent/mm/plugin/editor/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   282: goto -205 -> 77
    //   285: ldc_w 675
    //   288: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 5
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	WXRTEditText
    //   0	294	1	paramInt	int
    //   147	15	2	i	int
    //   52	79	3	bool	boolean
    //   69	4	4	localEditable	Editable
    //   182	89	4	localNullPointerException	java.lang.NullPointerException
    //   210	82	5	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   47	53	182	java/lang/NullPointerException
    //   71	77	210	java/lang/IndexOutOfBoundsException
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(181818);
    Object localObject1;
    int i;
    label382:
    boolean bool1;
    if (e.isEnabled())
    {
      localObject1 = getText();
      if (localObject1 == null)
      {
        bSP();
        AppMethodBeat.o(181818);
        return true;
      }
      int j = ((Editable)localObject1).length();
      i = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((j < 0) || (i < 0) || (i > j))
      {
        bSP();
        AppMethodBeat.o(181818);
        return true;
      }
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(181818);
            return true;
            j = (int)paramMotionEvent.getX();
            int k = (int)paramMotionEvent.getY();
            Object localObject2 = getLayout();
            k = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k), j);
            localObject2 = (s[])getText().getSpans(k, k + 1, s.class);
            if ((e.bSW().isEditable()) && (j < f.bSG()) && (localObject2.length != 0))
            {
              ad.i("noteeditor.WXRTEditText", "clicked todo");
              localObject2[0].a(this, (Spannable)localObject1, paramMotionEvent, localObject2[0]);
            }
            else
            {
              bSP();
              this.ooo.a(1, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), i);
              bSO();
              this.cbR.av(500L, 0L);
              continue;
              bSP();
              bSO();
            }
          }
          bSO();
        } while (this.ooo == null);
        localObject1 = this.ooo;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).opa = f1;
        ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).opb = f2;
        ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).opc = f3;
        ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).opd = f4;
        if (((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).nBH != 1) {
          break;
        }
        ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).ope = i;
        j = this.ooo.getType();
        bSP();
      } while (j != 2);
      if (e.bSW().isEditable()) {
        if (hasFocus())
        {
          if ((getSelectionStart() != getSelectionEnd()) || (i != getSelectionStart())) {
            break label698;
          }
          bool1 = true;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      setIgnoreSelectChangeByMultiSelect(true);
      setSelection(i);
      setIgnoreSelectChangeByMultiSelect(false);
      if (this.onP != null)
      {
        this.onP.e(true, 50L);
        this.onP.zZ(1);
      }
      fb(i, i);
      e.bSW().H(bool2, bool1);
      break;
      ((com.tencent.mm.plugin.editor.model.nativenote.c.b)localObject1).ope = 0;
      break label382;
      requestFocus();
      bool1 = false;
      bool2 = false;
      continue;
      paramMotionEvent = e.bSW().bSY();
      bool1 = bool2;
      if (e.bSW().bTe())
      {
        bool1 = bool2;
        if (paramMotionEvent.bSV() == 1)
        {
          bool1 = bool2;
          if (paramMotionEvent.cWU == this.oom)
          {
            bool1 = bool2;
            if (paramMotionEvent.startOffset == i) {
              bool1 = true;
            }
          }
        }
      }
      fb(i, i);
      paramMotionEvent = e.bSW();
      if (!e.mHasInit) {
        break;
      }
      paramMotionEvent.bTf();
      paramMotionEvent.bTd();
      paramMotionEvent.f(true, 50L);
      paramMotionEvent.jx(true);
      paramMotionEvent.jw(bool1);
      break;
      if ((paramMotionEvent.getAction() == 1) && (this.onP != null))
      {
        this.onP.e(true, 300L);
        this.onP.zZ(1);
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(181818);
      return bool1;
      label698:
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void setEditTextType(int paramInt)
  {
    this.onZ = paramInt;
  }
  
  public void setIgnoreSelectChangeByMultiSelect(boolean paramBoolean)
  {
    this.oop = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(181789);
    super.setMaxHeight(paramInt);
    AppMethodBeat.o(181789);
  }
  
  public void setPosInDataList(int paramInt)
  {
    this.oom = paramInt;
  }
  
  public void setRichTextEditing(String paramString)
  {
    AppMethodBeat.i(181792);
    bSJ();
    if (!bt.isNullOrNil(paramString)) {
      setSpannableText(com.tencent.mm.plugin.editor.model.nativenote.a.a.Tc(paramString));
    }
    for (;;)
    {
      bSK();
      AppMethodBeat.o(181792);
      return;
      setText("");
    }
  }
  
  public void setSpannableText(Spanned paramSpanned)
  {
    AppMethodBeat.i(181793);
    bSJ();
    bSL();
    super.setText(paramSpanned, TextView.BufferType.EDITABLE);
    bSM();
    bSN();
    u.a(this, new t[0]);
    bSK();
    AppMethodBeat.o(181793);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(181794);
    bSJ();
    super.setText(paramString);
    bSK();
    AppMethodBeat.o(181794);
  }
  
  public void setTextWithoutIgnore(String paramString)
  {
    AppMethodBeat.i(181795);
    super.setText(paramString);
    AppMethodBeat.o(181795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText
 * JD-Core Version:    0.7.0.1
 */