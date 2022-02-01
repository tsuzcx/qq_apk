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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button hJh;
  private Button ipd;
  private TextView pJB;
  private Button pJC;
  private Button pJD;
  private TextView pJE;
  private TextView pJF;
  private TextView pJG;
  private TextView pJH;
  private TextView pJI;
  private EditText pJJ;
  private Button pJK;
  private Button pJL;
  private int pJM = 0;
  
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
    this.pJB = ((TextView)$(2131301027));
    this.hJh = ((Button)$(2131298556));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122471);
        paramAnonymousView = ExptDebugUI.a(ExptDebugUI.this).getText().toString().trim();
        ExptDebugUI.a(ExptDebugUI.this, bt.getInt(paramAnonymousView, 0));
        AppMethodBeat.o(122471);
      }
    });
    this.pJJ = ((EditText)$(2131299615));
    this.pJK = ((Button)$(2131299616));
    this.pJK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122472);
        ExptDebugUI.b(ExptDebugUI.this);
        AppMethodBeat.o(122472);
      }
    });
    this.pJC = ((Button)$(2131299612));
    this.pJC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(122474);
        Object localObject = com.tencent.mm.plugin.expt.c.a.cdX().cea();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new c(ExptDebugUI.this.getContext(), paramAnonymousView);
          ((c)localObject).aaR(0);
          ((c)localObject).HIW = new c.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(122473);
              this.moo.hide();
              int i = this.moo.ffZ();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptDebugUI.a(ExptDebugUI.this, bt.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(122473);
            }
          };
          ((c)localObject).show();
        }
        AppMethodBeat.o(122474);
      }
    });
    this.pJD = ((Button)$(2131304094));
    this.pJD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122475);
        com.tencent.mm.plugin.expt.c.a.cdX();
        com.tencent.mm.plugin.expt.c.a.BM(1);
        Toast.makeText(ExptDebugUI.this.getContext(), "start req expt", 0).show();
        AppMethodBeat.o(122475);
      }
    });
    this.ipd = ((Button)$(2131299608));
    this.ipd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(122476);
        paramAnonymousView = com.tencent.mm.plugin.expt.c.a.cdX().BL(ExptDebugUI.c(ExptDebugUI.this));
        if ((paramAnonymousView != null) && (paramAnonymousView.ceu()))
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
          com.tencent.mm.plugin.expt.c.a.cdX();
          com.tencent.mm.plugin.expt.c.a.a(null, null, localLinkedList);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cev()))
        {
          com.tencent.mm.plugin.expt.c.a.cdX();
          com.tencent.mm.plugin.expt.c.a.d("", false, true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cew()))
        {
          com.tencent.mm.plugin.expt.c.a.cdX();
          com.tencent.mm.plugin.expt.c.a.aR("", true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.cex()))
        {
          com.tencent.mm.plugin.expt.c.a.cdX();
          com.tencent.mm.plugin.expt.c.a.a(paramAnonymousView.ceA(), "", true, false);
        }
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (com.tencent.mm.plugin.expt.c.a.cdX().da(paramAnonymousView) > 0) {}
        for (;;)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          AppMethodBeat.o(122476);
          return;
          bool = false;
        }
      }
    });
    this.pJL = ((Button)$(2131299609));
    this.pJL.setOnClickListener(new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	com/tencent/mm/plugin/expt/c/a:cdX	()Lcom/tencent/mm/plugin/expt/c/a;
        //   8: invokevirtual 41	com/tencent/mm/plugin/expt/c/a:cea	()Ljava/util/ArrayList;
        //   11: astore 5
        //   13: new 43	java/lang/StringBuilder
        //   16: dup
        //   17: invokespecial 44	java/lang/StringBuilder:<init>	()V
        //   20: invokestatic 50	com/tencent/mm/loader/j/b:aih	()Ljava/lang/String;
        //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   26: ldc 56
        //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   31: invokestatic 62	com/tencent/mm/sdk/platformtools/bt:aGK	()J
        //   34: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   37: ldc 67
        //   39: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   45: astore 4
        //   47: aload 4
        //   49: invokestatic 76	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
        //   52: ifeq +9 -> 61
        //   55: aload 4
        //   57: invokestatic 79	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
        //   60: pop
        //   61: aload 4
        //   63: invokestatic 82	com/tencent/mm/vfs/i:aMR	(Ljava/lang/String;)Z
        //   66: ifeq +78 -> 144
        //   69: aconst_null
        //   70: astore_3
        //   71: aload 4
        //   73: iconst_0
        //   74: invokestatic 86	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   77: astore_1
        //   78: aload 5
        //   80: invokevirtual 92	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   83: astore_3
        //   84: aload_3
        //   85: invokeinterface 98 1 0
        //   90: ifeq +150 -> 240
        //   93: aload_3
        //   94: invokeinterface 102 1 0
        //   99: checkcast 104	java/lang/Integer
        //   102: invokevirtual 108	java/lang/Integer:intValue	()I
        //   105: istore_2
        //   106: aload_1
        //   107: new 43	java/lang/StringBuilder
        //   110: dup
        //   111: invokespecial 44	java/lang/StringBuilder:<init>	()V
        //   114: iload_2
        //   115: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   118: ldc 113
        //   120: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   126: invokevirtual 119	java/lang/String:getBytes	()[B
        //   129: invokevirtual 125	java/io/OutputStream:write	([B)V
        //   132: goto -48 -> 84
        //   135: astore_3
        //   136: aload_1
        //   137: ifnull +7 -> 144
        //   140: aload_1
        //   141: invokevirtual 128	java/io/OutputStream:close	()V
        //   144: aload_0
        //   145: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:pJN	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   148: invokestatic 132	com/tencent/mm/plugin/expt/ui/ExptDebugUI:e	(Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;)Landroid/widget/TextView;
        //   151: ldc 134
        //   153: aload 4
        //   155: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   158: invokevirtual 142	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   161: invokevirtual 148	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
        //   164: invokestatic 154	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
        //   167: ldc 156
        //   169: invokevirtual 162	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   172: checkcast 164	android/content/ClipboardManager
        //   175: ldc 166
        //   177: aload 4
        //   179: invokestatic 172	android/content/ClipData:newPlainText	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;
        //   182: invokevirtual 176	android/content/ClipboardManager:setPrimaryClip	(Landroid/content/ClipData;)V
        //   185: aload_0
        //   186: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:pJN	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   189: invokevirtual 179	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   192: new 43	java/lang/StringBuilder
        //   195: dup
        //   196: invokespecial 44	java/lang/StringBuilder:<init>	()V
        //   199: aload_0
        //   200: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:pJN	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   203: invokevirtual 179	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   206: ldc 180
        //   208: invokevirtual 186	android/support/v7/app/AppCompatActivity:getString	(I)Ljava/lang/String;
        //   211: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   214: ldc 188
        //   216: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   219: aload 4
        //   221: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   224: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   227: iconst_0
        //   228: invokestatic 194	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   231: invokevirtual 197	android/widget/Toast:show	()V
        //   234: ldc 25
        //   236: invokestatic 200	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   239: return
        //   240: aload_1
        //   241: invokevirtual 203	java/io/OutputStream:flush	()V
        //   244: aload_1
        //   245: ifnull -101 -> 144
        //   248: aload_1
        //   249: invokevirtual 128	java/io/OutputStream:close	()V
        //   252: goto -108 -> 144
        //   255: astore_1
        //   256: goto -112 -> 144
        //   259: astore_1
        //   260: aconst_null
        //   261: astore_3
        //   262: aload_3
        //   263: ifnull +7 -> 270
        //   266: aload_3
        //   267: invokevirtual 128	java/io/OutputStream:close	()V
        //   270: ldc 25
        //   272: invokestatic 200	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   275: aload_1
        //   276: athrow
        //   277: astore_1
        //   278: aload_0
        //   279: getfield 14	com/tencent/mm/plugin/expt/ui/ExptDebugUI$7:pJN	Lcom/tencent/mm/plugin/expt/ui/ExptDebugUI;
        //   282: invokevirtual 179	com/tencent/mm/plugin/expt/ui/ExptDebugUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
        //   285: ldc 205
        //   287: iconst_0
        //   288: invokestatic 194	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
        //   291: invokevirtual 197	android/widget/Toast:show	()V
        //   294: ldc 25
        //   296: invokestatic 200	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   299: return
        //   300: astore_1
        //   301: goto -157 -> 144
        //   304: astore_3
        //   305: goto -35 -> 270
        //   308: astore_3
        //   309: aload_1
        //   310: astore 4
        //   312: aload_3
        //   313: astore_1
        //   314: aload 4
        //   316: astore_3
        //   317: goto -55 -> 262
        //   320: astore_1
        //   321: aload_3
        //   322: astore_1
        //   323: goto -187 -> 136
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	326	0	this	7
        //   0	326	1	paramAnonymousView	View
        //   105	10	2	i	int
        //   70	24	3	localIterator	java.util.Iterator
        //   135	1	3	localException	java.lang.Exception
        //   261	6	3	localObject1	Object
        //   304	1	3	localIOException	java.io.IOException
        //   308	5	3	localObject2	Object
        //   316	6	3	localObject3	Object
        //   45	270	4	localObject4	Object
        //   11	68	5	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   78	84	135	java/lang/Exception
        //   84	132	135	java/lang/Exception
        //   240	244	135	java/lang/Exception
        //   248	252	255	java/io/IOException
        //   71	78	259	finally
        //   164	234	277	java/lang/Exception
        //   140	144	300	java/io/IOException
        //   266	270	304	java/io/IOException
        //   78	84	308	finally
        //   84	132	308	finally
        //   240	244	308	finally
        //   71	78	320	java/lang/Exception
      }
    });
    this.pJE = ((TextView)$(2131299610));
    this.pJF = ((TextView)$(2131300635));
    this.pJG = ((TextView)$(2131299613));
    this.pJH = ((TextView)$(2131299614));
    this.pJI = ((TextView)$(2131299607));
    AppMethodBeat.o(122477);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */