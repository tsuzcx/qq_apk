package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.h.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button gUt;
  private Button jis;
  private TextView rbK;
  private Button rbL;
  private Button rbN;
  private TextView rbO;
  private TextView rbP;
  private TextView rbQ;
  private TextView rbR;
  private TextView rbS;
  private EditText rbT;
  private Button rbU;
  private Button rbV;
  private int rbW = 0;
  
  public int getLayoutId()
  {
    return 2131492933;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122477);
    super.onCreate(paramBundle);
    setMMTitle("Expt debug ui");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(122470);
        ExptDebugUI.this.finish();
        AppMethodBeat.o(122470);
        return true;
      }
    });
    this.rbK = ((TextView)$(2131301027));
    this.gUt = ((Button)$(2131298556));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122471);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = ExptDebugUI.a(ExptDebugUI.this).getText().toString().trim();
        ExptDebugUI.a(ExptDebugUI.this, bt.getInt(paramAnonymousView, 0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122471);
      }
    });
    this.rbT = ((EditText)$(2131299615));
    this.rbU = ((Button)$(2131299616));
    this.rbU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122472);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ExptDebugUI.b(ExptDebugUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122472);
      }
    });
    this.rbL = ((Button)$(2131299612));
    this.rbL.setOnClickListener(new ExptDebugUI.4(this));
    this.rbN = ((Button)$(2131304094));
    this.rbN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122475);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.plugin.expt.f.a.cqZ();
        com.tencent.mm.plugin.expt.f.a.Dw(1);
        Toast.makeText(ExptDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122475);
      }
    });
    this.jis = ((Button)$(2131299608));
    this.jis.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122476);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = com.tencent.mm.plugin.expt.f.a.cqZ().Dv(ExptDebugUI.c(ExptDebugUI.this));
        if ((paramAnonymousView != null) && (paramAnonymousView.crD()))
        {
          localObject = new LinkedList();
          ((List)localObject).add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
          com.tencent.mm.plugin.expt.f.a.cqZ();
          com.tencent.mm.plugin.expt.f.a.a(null, null, (List)localObject);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.crE()))
        {
          com.tencent.mm.plugin.expt.f.a.cqZ();
          com.tencent.mm.plugin.expt.f.a.e("", false, true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.crF()))
        {
          com.tencent.mm.plugin.expt.f.a.cqZ();
          com.tencent.mm.plugin.expt.f.a.aU("", true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.crG()))
        {
          com.tencent.mm.plugin.expt.f.a.cqZ();
          com.tencent.mm.plugin.expt.f.a.a(paramAnonymousView.crN(), "", true, false);
        }
        com.tencent.mm.plugin.expt.f.a.cqZ();
        com.tencent.mm.plugin.expt.f.a.a(paramAnonymousView, true);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (com.tencent.mm.plugin.expt.f.a.cqZ().de(paramAnonymousView) > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122476);
          return;
        }
      }
    });
    this.rbV = ((Button)$(2131299609));
    this.rbV.setOnClickListener(new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 33	com/tencent/mm/hellhoundlib/b/b
        //   8: dup
        //   9: invokespecial 34	com/tencent/mm/hellhoundlib/b/b:<init>	()V
        //   12: astore_3
        //   13: aload_3
        //   14: aload_1
        //   15: invokevirtual 38	com/tencent/mm/hellhoundlib/b/b:bd	(Ljava/lang/Object;)V
        //   18: ldc 39
        //   20: ldc 40
        //   22: ldc 41
        //   24: ldc 42
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 46	com/tencent/mm/hellhoundlib/b/b:ahq	()[Ljava/lang/Object;
        //   31: invokestatic 52	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: invokestatic 58	com/tencent/mm/plugin/expt/f/a:cqZ	()Lcom/tencent/mm/plugin/expt/f/a;
        //   37: invokevirtual 62	com/tencent/mm/plugin/expt/f/a:crc	()Ljava/util/ArrayList;
        //   40: astore 5
        //   42: new 64	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   49: invokestatic 71	com/tencent/mm/loader/j/b:arU	()Ljava/lang/String;
        //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   55: ldc 77
        //   57: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: invokestatic 83	com/tencent/mm/sdk/platformtools/bt:aQJ	()J
        //   63: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   66: ldc 88
        //   68: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   71: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   74: astore 4
        //   76: aload 4
        //   78: invokestatic 97	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
        //   81: ifeq +9 -> 90
        //   84: aload 4
        //   86: invokestatic 100	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
        //   89: pop
        //   90: aload 4
        //   92: invokestatic 103	com/tencent/mm/vfs/i:aYs	(Ljava/lang/String;)Z
        //   95: ifeq +78 -> 173
        //   98: aconst_null
        //   99: astore_3
        //   100: aload 4
        //   102: iconst_0
        //   103: invokestatic 107	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   106: astore_1
        //   107: aload 5
        //   109: invokevirtual 113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   112: astore_3
        //   113: aload_3
        //   114: invokeinterface 119 1 0
        //   119: ifeq +162 -> 281
        //   122: aload_3
        //   123: invokeinterface 123 1 0
        //   128: checkcast 125	java/lang/Integer
        //   131: invokevirtual 129	java/lang/Integer:intValue	()I
        //   134: istore_2
        //   135: aload_1
        //   136: new 64	java/lang/StringBuilder
        //   139: dup
        //   140: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   143: iload_2
        //   144: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   147: ldc 134
        //   149: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   155: invokevirtual 140	java/lang/String:getBytes	()[B
        //   158: invokevirtual 146	java/io/OutputStream:write	([B)V
        //   161: goto -48 -> 113
        //   164: astore_3
        //   165: aload_1
        //   166: ifnull +7 -> 173
        //   169: aload_1
        //   170: invokevirtual 149	java/io/OutputStream:close	()V
        //   173: aload_0
        //   174: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:rca	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   177: invokestatic 153	com/tencent/mm/plugin/expt/ui/ExptDebugUI:e	(Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;)Landroid/widget/TextView;
        //   180: ldc 155
        //   182: aload 4
        //   184: invokestatic 159	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   187: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   190: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
        //   193: invokestatic 175	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
        //   196: ldc 177
        //   198: invokevirtual 183	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   201: checkcast 185	android/content/ClipboardManager
        //   204: ldc 187
        //   206: aload 4
        //   208: invokestatic 193	android/content/ClipData:newPlainText	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;
        //   211: invokevirtual 197	android/content/ClipboardManager:setPrimaryClip	(Landroid/content/ClipData;)V
        //   214: aload_0
        //   215: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:rca	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   218: invokevirtual 200	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   221: new 64	java/lang/StringBuilder
        //   224: dup
        //   225: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   228: aload_0
        //   229: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:rca	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   232: invokevirtual 200	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   235: ldc 201
        //   237: invokevirtual 207	android/support/v7/app/AppCompatActivity:getString	(I)Ljava/lang/String;
        //   240: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   243: ldc 209
        //   245: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: aload 4
        //   250: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   253: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   256: iconst_0
        //   257: invokestatic 215	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   260: invokevirtual 218	android/widget/Toast:show	()V
        //   263: aload_0
        //   264: ldc 39
        //   266: ldc 40
        //   268: ldc 41
        //   270: ldc 42
        //   272: invokestatic 222	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   275: ldc 25
        //   277: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   280: return
        //   281: aload_1
        //   282: invokevirtual 228	java/io/OutputStream:flush	()V
        //   285: aload_1
        //   286: ifnull -113 -> 173
        //   289: aload_1
        //   290: invokevirtual 149	java/io/OutputStream:close	()V
        //   293: goto -120 -> 173
        //   296: astore_1
        //   297: goto -124 -> 173
        //   300: astore_1
        //   301: aconst_null
        //   302: astore_3
        //   303: aload_3
        //   304: ifnull +7 -> 311
        //   307: aload_3
        //   308: invokevirtual 149	java/io/OutputStream:close	()V
        //   311: ldc 25
        //   313: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   316: aload_1
        //   317: athrow
        //   318: astore_1
        //   319: aload_0
        //   320: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:rca	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   323: invokevirtual 200	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   326: ldc 230
        //   328: iconst_0
        //   329: invokestatic 215	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   332: invokevirtual 218	android/widget/Toast:show	()V
        //   335: goto -72 -> 263
        //   338: astore_1
        //   339: goto -166 -> 173
        //   342: astore_3
        //   343: goto -32 -> 311
        //   346: astore_3
        //   347: aload_1
        //   348: astore 4
        //   350: aload_3
        //   351: astore_1
        //   352: aload 4
        //   354: astore_3
        //   355: goto -52 -> 303
        //   358: astore_1
        //   359: aload_3
        //   360: astore_1
        //   361: goto -196 -> 165
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	364	0	this	7
        //   0	364	1	paramAnonymousView	View
        //   134	10	2	i	int
        //   12	111	3	localObject1	Object
        //   164	1	3	localException	java.lang.Exception
        //   302	6	3	localObject2	Object
        //   342	1	3	localIOException	java.io.IOException
        //   346	5	3	localObject3	Object
        //   354	6	3	localObject4	Object
        //   74	279	4	localObject5	Object
        //   40	68	5	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   107	113	164	java/lang/Exception
        //   113	161	164	java/lang/Exception
        //   281	285	164	java/lang/Exception
        //   289	293	296	java/io/IOException
        //   100	107	300	finally
        //   193	263	318	java/lang/Exception
        //   169	173	338	java/io/IOException
        //   307	311	342	java/io/IOException
        //   107	113	346	finally
        //   113	161	346	finally
        //   281	285	346	finally
        //   100	107	358	java/lang/Exception
      }
    });
    this.rbO = ((TextView)$(2131299610));
    this.rbP = ((TextView)$(2131300635));
    this.rbQ = ((TextView)$(2131299613));
    this.rbR = ((TextView)$(2131299614));
    this.rbS = ((TextView)$(2131299607));
    AppMethodBeat.o(122477);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */