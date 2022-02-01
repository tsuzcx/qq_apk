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
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.h.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button kEt;
  private Button nbe;
  private EditText wrA;
  private Button wrB;
  private Button wrC;
  private int wrD = 0;
  private TextView wrr;
  private Button wrs;
  private Button wru;
  private TextView wrv;
  private TextView wrw;
  private TextView wrx;
  private TextView wry;
  private TextView wrz;
  
  public int getLayoutId()
  {
    return b.d.activity_expt_debug;
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
    this.wrr = ((TextView)$(b.c.input_exptId));
    this.kEt = ((Button)$(b.c.confirm_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122471);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = ExptDebugUI.a(ExptDebugUI.this).getText().toString().trim();
        ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymousView, 0));
        f.Iyx.kvStat(9999, "1");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122471);
      }
    });
    this.wrA = ((EditText)$(b.c.expt_xml));
    this.wrB = ((Button)$(b.c.expt_xml_confirm));
    this.wrB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122472);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ExptDebugUI.b(ExptDebugUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122472);
      }
    });
    this.wrs = ((Button)$(b.c.expt_picker));
    this.wrs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(122474);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = com.tencent.mm.plugin.expt.f.a.dgf().dgh();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new com.tencent.mm.ui.widget.picker.b(ExptDebugUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).ayK(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).YrN = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(122473);
              this.rHY.hide();
              int i = this.rHY.idp();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(122473);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122474);
      }
    });
    this.wru = ((Button)$(b.c.req_expt));
    this.wru.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122475);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.expt.f.a.dgf();
        com.tencent.mm.plugin.expt.f.a.Lg(1);
        Toast.makeText(ExptDebugUI.this.getContext(), "start req expt", 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122475);
      }
    });
    this.nbe = ((Button)$(b.c.expt_del));
    this.nbe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122476);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.plugin.expt.f.a.dgf().Lf(ExptDebugUI.c(ExptDebugUI.this));
        if ((paramAnonymousView != null) && (paramAnonymousView.dgL()))
        {
          localObject = new LinkedList();
          ((List)localObject).add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
          com.tencent.mm.plugin.expt.f.a.dgf();
          com.tencent.mm.plugin.expt.f.a.a(null, null, (List)localObject);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.dgM()))
        {
          com.tencent.mm.plugin.expt.f.a.dgf();
          com.tencent.mm.plugin.expt.f.a.f("", false, true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.dgN()))
        {
          com.tencent.mm.plugin.expt.f.a.dgf();
          com.tencent.mm.plugin.expt.f.a.bb("", true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.dgO()))
        {
          com.tencent.mm.plugin.expt.f.a.dgf();
          com.tencent.mm.plugin.expt.f.a.b(paramAnonymousView.dgV(), "", true, false);
        }
        com.tencent.mm.plugin.expt.f.a.dgf();
        com.tencent.mm.plugin.expt.f.a.a(paramAnonymousView, true);
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (com.tencent.mm.plugin.expt.f.a.dgf().dB(paramAnonymousView) > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(122476);
          return;
        }
      }
    });
    this.wrC = ((Button)$(b.c.expt_export));
    this.wrC.setOnClickListener(new View.OnClickListener()
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
        //   15: invokevirtual 38	com/tencent/mm/hellhoundlib/b/b:bn	(Ljava/lang/Object;)V
        //   18: ldc 39
        //   20: ldc 40
        //   22: ldc 41
        //   24: ldc 42
        //   26: aload_0
        //   27: aload_3
        //   28: invokevirtual 46	com/tencent/mm/hellhoundlib/b/b:aFi	()[Ljava/lang/Object;
        //   31: invokestatic 52	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   34: invokestatic 58	com/tencent/mm/plugin/expt/f/a:dgf	()Lcom/tencent/mm/plugin/expt/f/a;
        //   37: invokevirtual 62	com/tencent/mm/plugin/expt/f/a:dgh	()Ljava/util/ArrayList;
        //   40: astore 5
        //   42: new 64	java/lang/StringBuilder
        //   45: dup
        //   46: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   49: invokestatic 71	com/tencent/mm/loader/j/b:aSL	()Ljava/lang/String;
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
        //   78: invokestatic 97	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
        //   81: ifeq +9 -> 90
        //   84: aload 4
        //   86: invokestatic 100	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
        //   89: pop
        //   90: aload 4
        //   92: invokestatic 103	com/tencent/mm/vfs/u:bBV	(Ljava/lang/String;)Z
        //   95: ifeq +77 -> 172
        //   98: aconst_null
        //   99: astore_3
        //   100: aload 4
        //   102: invokestatic 107	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
        //   105: astore_1
        //   106: aload 5
        //   108: invokevirtual 113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   111: astore_3
        //   112: aload_3
        //   113: invokeinterface 119 1 0
        //   118: ifeq +152 -> 270
        //   121: aload_3
        //   122: invokeinterface 123 1 0
        //   127: checkcast 125	java/lang/Integer
        //   130: invokevirtual 129	java/lang/Integer:intValue	()I
        //   133: istore_2
        //   134: aload_1
        //   135: new 64	java/lang/StringBuilder
        //   138: dup
        //   139: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   142: iload_2
        //   143: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   146: ldc 134
        //   148: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   151: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   154: invokevirtual 140	java/lang/String:getBytes	()[B
        //   157: invokevirtual 146	java/io/OutputStream:write	([B)V
        //   160: goto -48 -> 112
        //   163: astore_3
        //   164: aload_1
        //   165: ifnull +7 -> 172
        //   168: aload_1
        //   169: invokevirtual 149	java/io/OutputStream:close	()V
        //   172: aload_0
        //   173: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:wrH	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   176: invokestatic 153	com/tencent/mm/plugin/expt/ui/ExptDebugUI:e	(Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;)Landroid/widget/TextView;
        //   179: ldc 155
        //   181: aload 4
        //   183: invokestatic 159	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   186: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   189: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
        //   192: invokestatic 175	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   195: ldc 177
        //   197: aload 4
        //   199: invokestatic 182	com/tencent/mm/sdk/platformtools/ClipboardHelper:setText	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V
        //   202: aload_0
        //   203: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:wrH	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   206: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
        //   209: new 64	java/lang/StringBuilder
        //   212: dup
        //   213: invokespecial 65	java/lang/StringBuilder:<init>	()V
        //   216: aload_0
        //   217: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:wrH	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   220: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
        //   223: getstatic 191	com/tencent/mm/plugin/expt/b$e:app_copy_ok	I
        //   226: invokevirtual 197	androidx/appcompat/app/AppCompatActivity:getString	(I)Ljava/lang/String;
        //   229: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: ldc 199
        //   234: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: aload 4
        //   239: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   245: iconst_0
        //   246: invokestatic 205	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   249: invokevirtual 208	android/widget/Toast:show	()V
        //   252: aload_0
        //   253: ldc 39
        //   255: ldc 40
        //   257: ldc 41
        //   259: ldc 42
        //   261: invokestatic 212	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   264: ldc 25
        //   266: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   269: return
        //   270: aload_1
        //   271: invokevirtual 218	java/io/OutputStream:flush	()V
        //   274: aload_1
        //   275: ifnull -103 -> 172
        //   278: aload_1
        //   279: invokevirtual 149	java/io/OutputStream:close	()V
        //   282: goto -110 -> 172
        //   285: astore_1
        //   286: goto -114 -> 172
        //   289: astore_1
        //   290: aconst_null
        //   291: astore_3
        //   292: aload_3
        //   293: ifnull +7 -> 300
        //   296: aload_3
        //   297: invokevirtual 149	java/io/OutputStream:close	()V
        //   300: ldc 25
        //   302: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   305: aload_1
        //   306: athrow
        //   307: astore_1
        //   308: aload_0
        //   309: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:wrH	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   312: invokevirtual 185	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
        //   315: ldc 220
        //   317: iconst_0
        //   318: invokestatic 205	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   321: invokevirtual 208	android/widget/Toast:show	()V
        //   324: goto -72 -> 252
        //   327: astore_1
        //   328: goto -156 -> 172
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
        //   350: goto -186 -> 164
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	353	0	this	7
        //   0	353	1	paramAnonymousView	View
        //   133	10	2	i	int
        //   12	110	3	localObject1	Object
        //   163	1	3	localException	java.lang.Exception
        //   291	6	3	localObject2	Object
        //   331	1	3	localIOException	java.io.IOException
        //   335	5	3	localObject3	Object
        //   343	6	3	localObject4	Object
        //   74	268	4	localObject5	Object
        //   40	67	5	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   106	112	163	java/lang/Exception
        //   112	160	163	java/lang/Exception
        //   270	274	163	java/lang/Exception
        //   278	282	285	java/io/IOException
        //   100	106	289	finally
        //   192	252	307	java/lang/Exception
        //   168	172	327	java/io/IOException
        //   296	300	331	java/io/IOException
        //   106	112	335	finally
        //   112	160	335	finally
        //   270	274	335	finally
        //   100	106	347	java/lang/Exception
      }
    });
    this.wrv = ((TextView)$(b.c.expt_id));
    this.wrw = ((TextView)$(b.c.group_id));
    this.wrx = ((TextView)$(b.c.expt_seq));
    this.wry = ((TextView)$(b.c.expt_time));
    this.wrz = ((TextView)$(b.c.expt_args));
    AppMethodBeat.o(122477);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */