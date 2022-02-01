package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button hPX;
  private Button kjo;
  private TextView sLA;
  private TextView sLB;
  private TextView sLC;
  private TextView sLD;
  private TextView sLE;
  private EditText sLF;
  private Button sLG;
  private Button sLH;
  private int sLI = 0;
  private TextView sLw;
  private Button sLx;
  private Button sLz;
  
  public int getLayoutId()
  {
    return 2131492956;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122477);
    super.onCreate(paramBundle);
    setMMTitle("Expt debug ui");
    setBackBtn(new ExptDebugUI.1(this));
    this.sLw = ((TextView)$(2131302675));
    this.hPX = ((Button)$(2131298990));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122471);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = ExptDebugUI.a(ExptDebugUI.this).getText().toString().trim();
        ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymousView, 0));
        e.Cxv.kvStat(9999, "1");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122471);
      }
    });
    this.sLF = ((EditText)$(2131300249));
    this.sLG = ((Button)$(2131300250));
    this.sLG.setOnClickListener(new ExptDebugUI.3(this));
    this.sLx = ((Button)$(2131300246));
    this.sLx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(122474);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = com.tencent.mm.plugin.expt.f.a.cRk().cRm();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new com.tencent.mm.ui.widget.picker.c(ExptDebugUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.c)localObject).app(0);
          ((com.tencent.mm.ui.widget.picker.c)localObject).QTc = new c.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(122473);
              this.oGj.hide();
              int i = this.oGj.hci();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(122473);
            }
          };
          ((com.tencent.mm.ui.widget.picker.c)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122474);
      }
    });
    this.sLz = ((Button)$(2131306960));
    this.sLz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122475);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.expt.f.a.cRk();
        com.tencent.mm.plugin.expt.f.a.Hw(1);
        Toast.makeText(ExptDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122475);
      }
    });
    this.kjo = ((Button)$(2131300242));
    this.kjo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122476);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = com.tencent.mm.plugin.expt.f.a.cRk().Hv(ExptDebugUI.c(ExptDebugUI.this));
        if ((paramAnonymousView != null) && (paramAnonymousView.cRM()))
        {
          localObject = new LinkedList();
          ((List)localObject).add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
          com.tencent.mm.plugin.expt.f.a.cRk();
          com.tencent.mm.plugin.expt.f.a.a(null, null, (List)localObject);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cRN()))
        {
          com.tencent.mm.plugin.expt.f.a.cRk();
          com.tencent.mm.plugin.expt.f.a.f("", false, true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cRO()))
        {
          com.tencent.mm.plugin.expt.f.a.cRk();
          com.tencent.mm.plugin.expt.f.a.aY("", true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cRP()))
        {
          com.tencent.mm.plugin.expt.f.a.cRk();
          com.tencent.mm.plugin.expt.f.a.b(paramAnonymousView.cRW(), "", true, false);
        }
        com.tencent.mm.plugin.expt.f.a.cRk();
        com.tencent.mm.plugin.expt.f.a.a(paramAnonymousView, true);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (com.tencent.mm.plugin.expt.f.a.cRk().dv(paramAnonymousView) > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122476);
          return;
        }
      }
    });
    this.sLH = ((Button)$(2131300243));
    this.sLH.setOnClickListener(new View.OnClickListener()
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
        //   15: invokevirtual 38	com/tencent/mm/hellhoundlib/b/b:bm	(Ljava/lang/Object;)V
        //   18: ldc 39
        //   20: ldc 40
        //   22: ldc 41
        //   24: ldc 42
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 46	com/tencent/mm/hellhoundlib/b/b:axR	()[Ljava/lang/Object;
        //   31: invokestatic 52	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: invokestatic 58	com/tencent/mm/plugin/expt/f/a:cRk	()Lcom/tencent/mm/plugin/expt/f/a;
        //   37: invokevirtual 62	com/tencent/mm/plugin/expt/f/a:cRm	()Ljava/util/ArrayList;
        //   40: astore 5
        //   42: new 64	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   49: invokestatic 71	com/tencent/mm/loader/j/b:aKJ	()Ljava/lang/String;
        //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   55: ldc 77
        //   57: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   60: invokestatic 83	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
        //   63: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   66: ldc 88
        //   68: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   71: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   74: astore 4
        //   76: aload 4
        //   78: invokestatic 97	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
        //   81: ifeq +9 -> 90
        //   84: aload 4
        //   86: invokestatic 100	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
        //   89: pop
        //   90: aload 4
        //   92: invokestatic 103	com/tencent/mm/vfs/s:bpa	(Ljava/lang/String;)Z
        //   95: ifeq +78 -> 173
        //   98: aconst_null
        //   99: astore_3
        //   100: aload 4
        //   102: iconst_0
        //   103: invokestatic 107	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   106: astore_1
        //   107: aload 5
        //   109: invokevirtual 113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   112: astore_3
        //   113: aload_3
        //   114: invokeinterface 119 1 0
        //   119: ifeq +151 -> 270
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
        //   174: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:sLM	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   177: invokestatic 153	com/tencent/mm/plugin/expt/ui/ExptDebugUI:e	(Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;)Landroid/widget/TextView;
        //   180: ldc 155
        //   182: aload 4
        //   184: invokestatic 159	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   187: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   190: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
        //   193: invokestatic 175	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   196: ldc 177
        //   198: aload 4
        //   200: invokestatic 182	com/tencent/mm/sdk/platformtools/ClipboardHelper:setText	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
        //   203: aload_0
        //   204: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:sLM	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   207: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   210: new 64	java/lang/StringBuilder
        //   213: dup
        //   214: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   217: aload_0
        //   218: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:sLM	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   221: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   224: ldc 186
        //   226: invokevirtual 192	android/support/v7/app/AppCompatActivity:getString	(I)Ljava/lang/String;
        //   229: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: ldc 194
        //   234: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: aload 4
        //   239: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   245: iconst_0
        //   246: invokestatic 200	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   249: invokevirtual 203	android/widget/Toast:show	()V
        //   252: aload_0
        //   253: ldc 39
        //   255: ldc 40
        //   257: ldc 41
        //   259: ldc 42
        //   261: invokestatic 207	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   264: ldc 25
        //   266: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   269: return
        //   270: aload_1
        //   271: invokevirtual 213	java/io/OutputStream:flush	()V
        //   274: aload_1
        //   275: ifnull -102 -> 173
        //   278: aload_1
        //   279: invokevirtual 149	java/io/OutputStream:close	()V
        //   282: goto -109 -> 173
        //   285: astore_1
        //   286: goto -113 -> 173
        //   289: astore_1
        //   290: aconst_null
        //   291: astore_3
        //   292: aload_3
        //   293: ifnull +7 -> 300
        //   296: aload_3
        //   297: invokevirtual 149	java/io/OutputStream:close	()V
        //   300: ldc 25
        //   302: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   305: aload_1
        //   306: athrow
        //   307: astore_1
        //   308: aload_0
        //   309: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:sLM	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   312: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   315: ldc 215
        //   317: iconst_0
        //   318: invokestatic 200	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   321: invokevirtual 203	android/widget/Toast:show	()V
        //   324: goto -72 -> 252
        //   327: astore_1
        //   328: goto -155 -> 173
        //   331: astore_3
        //   332: goto -32 -> 300
        //   335: astore_3
        //   336: aload_1
        //   337: astore 4
        //   339: aload_3
        //   340: astore_1
        //   341: aload 4
        //   343: astore_3
        //   344: goto -52 -> 292
        //   347: astore_1
        //   348: aload_3
        //   349: astore_1
        //   350: goto -185 -> 165
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	353	0	this	7
        //   0	353	1	paramAnonymousView	View
        //   134	10	2	i	int
        //   12	111	3	localObject1	Object
        //   164	1	3	localException	java.lang.Exception
        //   291	6	3	localObject2	Object
        //   331	1	3	localIOException	java.io.IOException
        //   335	5	3	localObject3	Object
        //   343	6	3	localObject4	Object
        //   74	268	4	localObject5	Object
        //   40	68	5	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   107	113	164	java/lang/Exception
        //   113	161	164	java/lang/Exception
        //   270	274	164	java/lang/Exception
        //   278	282	285	java/io/IOException
        //   100	107	289	finally
        //   193	252	307	java/lang/Exception
        //   169	173	327	java/io/IOException
        //   296	300	331	java/io/IOException
        //   107	113	335	finally
        //   113	161	335	finally
        //   270	274	335	finally
        //   100	107	347	java/lang/Exception
      }
    });
    this.sLA = ((TextView)$(2131300244));
    this.sLB = ((TextView)$(2131302192));
    this.sLC = ((TextView)$(2131300247));
    this.sLD = ((TextView)$(2131300248));
    this.sLE = ((TextView)$(2131300241));
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