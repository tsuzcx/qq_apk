package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class c
  implements b
{
  private Class<?> whK;
  private Field whL;
  private Field whM;
  private Field wif;
  private Field wig;
  private Field wih;
  private Field wii;
  private Field wij;
  private Field wik;
  
  public c()
  {
    AppMethodBeat.i(169314);
    try
    {
      this.whK = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
      this.whL = this.whK.getDeclaredField("timeLineObject");
      this.whL.setAccessible(true);
      this.wif = this.whK.getDeclaredField("isAd");
      this.wif.setAccessible(true);
      this.whM = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
      this.whM.setAccessible(true);
      this.wig = this.whK.getDeclaredField("snsobj");
      this.wig.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.protocal.protobuf.SnsObject");
      this.wii = localClass.getDeclaredField("CommentUserList");
      this.wii.setAccessible(true);
      this.wih = localClass.getDeclaredField("LikeCount");
      this.wih.setAccessible(true);
      this.wij = localClass.getDeclaredField("Username");
      this.wij.setAccessible(true);
      this.wik = localClass.getDeclaredField("Nickname");
      this.wik.setAccessible(true);
      AppMethodBeat.o(169314);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(169314);
    }
  }
  
  public final String KI(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public final void a(View paramView, com.tencent.mm.pointers.PInt paramPInt1, com.tencent.mm.pointers.PInt paramPInt2, int paramInt)
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: iconst_0
    //   7: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   10: aload_3
    //   11: iconst_0
    //   12: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   15: aload_1
    //   16: invokevirtual 108	android/view/View:getTag	()Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +9 -> 30
    //   24: ldc 96
    //   26: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_0
    //   31: getfield 69	com/tencent/mm/plugin/expt/hellhound/a/a/a/c:wig	Ljava/lang/reflect/Field;
    //   34: astore 7
    //   36: aload 7
    //   38: ifnonnull +9 -> 47
    //   41: ldc 96
    //   43: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: return
    //   47: aload_0
    //   48: getfield 69	com/tencent/mm/plugin/expt/hellhound/a/a/a/c:wig	Ljava/lang/reflect/Field;
    //   51: aload_1
    //   52: invokevirtual 112	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +101 -> 158
    //   60: aload_0
    //   61: getfield 79	com/tencent/mm/plugin/expt/hellhound/a/a/a/c:wih	Ljava/lang/reflect/Field;
    //   64: aload_1
    //   65: invokevirtual 112	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 114	java/lang/Integer
    //   71: invokevirtual 118	java/lang/Integer:intValue	()I
    //   74: istore 4
    //   76: aload_0
    //   77: getfield 75	com/tencent/mm/plugin/expt/hellhound/a/a/a/c:wii	Ljava/lang/reflect/Field;
    //   80: aload_1
    //   81: invokevirtual 112	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 120	java/util/LinkedList
    //   87: astore_1
    //   88: iload 4
    //   90: istore 5
    //   92: aload_1
    //   93: ifnull +55 -> 148
    //   96: aload_1
    //   97: invokevirtual 123	java/util/LinkedList:size	()I
    //   100: istore 6
    //   102: iload 4
    //   104: istore 5
    //   106: iload 6
    //   108: istore 4
    //   110: aload_2
    //   111: iload 5
    //   113: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   116: aload_3
    //   117: iload 4
    //   119: putfield 102	com/tencent/mm/pointers/PInt:value	I
    //   122: ldc 96
    //   124: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: astore_1
    //   129: iconst_0
    //   130: istore 4
    //   132: ldc 125
    //   134: aload_1
    //   135: ldc 127
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iload 4
    //   146: istore 5
    //   148: iconst_0
    //   149: istore 4
    //   151: goto -41 -> 110
    //   154: astore_1
    //   155: goto -23 -> 132
    //   158: iconst_0
    //   159: istore 4
    //   161: iconst_0
    //   162: istore 5
    //   164: goto -54 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	c
    //   0	167	1	paramView	View
    //   0	167	2	paramPInt1	com.tencent.mm.pointers.PInt
    //   0	167	3	paramPInt2	com.tencent.mm.pointers.PInt
    //   0	167	4	paramInt	int
    //   90	73	5	i	int
    //   100	7	6	j	int
    //   34	3	7	localField	Field
    // Exception table:
    //   from	to	target	type
    //   30	36	128	java/lang/Exception
    //   47	56	128	java/lang/Exception
    //   60	76	128	java/lang/Exception
    //   76	88	154	java/lang/Exception
    //   96	102	154	java/lang/Exception
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(169315);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(169315);
      return null;
    }
    try
    {
      boolean bool = this.whK.isInstance(paramView);
      if (!bool)
      {
        AppMethodBeat.o(169315);
        return null;
      }
      paramView = this.whL.get(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(169315);
        return null;
      }
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(169315);
      return null;
    }
    try
    {
      paramView = (String)this.whM.get(paramView);
      AppMethodBeat.o(169315);
      return paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", paramView, "getFeedParams.feedId: ", new Object[0]);
        paramView = null;
      }
    }
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(169317);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(169317);
      return null;
    }
    try
    {
      Field localField = this.wig;
      if (localField == null)
      {
        AppMethodBeat.o(169317);
        return null;
      }
      paramView = this.wig.get(paramView);
      if (paramView == null) {
        break label82;
      }
      paramView = (String)this.wij.get(paramView);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", paramView, "get feed info error!", new Object[0]);
        paramView = null;
      }
    }
    AppMethodBeat.o(169317);
    return paramView;
  }
  
  public final String ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(185579);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(185579);
      return null;
    }
    try
    {
      Field localField = this.wig;
      if (localField == null)
      {
        AppMethodBeat.o(185579);
        return null;
      }
      paramView = this.wig.get(paramView);
      if (paramView == null) {
        break label82;
      }
      paramView = (String)this.wik.get(paramView);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", paramView, "get feed info error!", new Object[0]);
        paramView = null;
      }
    }
    AppMethodBeat.o(185579);
    return paramView;
  }
  
  public final boolean en(View paramView)
  {
    AppMethodBeat.i(184357);
    paramView = paramView.getTag();
    if (paramView == null)
    {
      AppMethodBeat.o(184357);
      return false;
    }
    try
    {
      bool = this.whK.isInstance(paramView);
      if (!bool)
      {
        AppMethodBeat.o(184357);
        return false;
      }
      bool = ((Boolean)this.wif.get(paramView)).booleanValue();
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    AppMethodBeat.o(184357);
    return bool;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */