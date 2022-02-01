package com.tencent.mm.plugin.finder.feed.jumper;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderEmojiJumperHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/BaseJumperEventHandler;", "()V", "handleEmojiOnClick", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "onClickDo", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "Landroid/view/View;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends d
{
  /* Error */
  public final void a(com.tencent.mm.view.recyclerview.j paramj, android.view.View paramView, k paramk)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 45
    //   8: invokestatic 51	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 52
    //   14: invokestatic 51	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: ldc 53
    //   20: invokestatic 51	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_1
    //   24: getfield 57	com/tencent/mm/view/recyclerview/j:context	Landroid/content/Context;
    //   27: astore_1
    //   28: aload_1
    //   29: ldc 59
    //   31: invokestatic 62	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   34: aload_3
    //   35: getfield 67	com/tencent/mm/plugin/finder/feed/jumper/k:hVf	Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;
    //   38: getfield 73	com/tencent/mm/protocal/protobuf/FinderJumpInfo:native_info	Lcom/tencent/mm/protocal/protobuf/NativeInfo;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +181 -> 224
    //   46: aload_2
    //   47: getfield 79	com/tencent/mm/protocal/protobuf/NativeInfo:necessary_params	Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: checkcast 81	java/lang/CharSequence
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +12 -> 69
    //   60: aload_3
    //   61: invokeinterface 85 1 0
    //   66: ifne +139 -> 205
    //   69: iconst_1
    //   70: istore 4
    //   72: iload 4
    //   74: ifne +150 -> 224
    //   77: new 87	org/json/JSONObject
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 90	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_2
    //   86: aload_2
    //   87: ldc 92
    //   89: invokevirtual 96	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   92: ifeq +132 -> 224
    //   95: aload_2
    //   96: ldc 92
    //   98: invokevirtual 100	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: new 102	android/content/Intent
    //   105: dup
    //   106: aload_1
    //   107: ldc 104
    //   109: invokespecial 107	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   112: astore_3
    //   113: aload_3
    //   114: ldc 109
    //   116: aload_2
    //   117: invokevirtual 113	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   120: pop
    //   121: aload_3
    //   122: ldc 115
    //   124: bipush 106
    //   126: invokevirtual 118	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   129: pop
    //   130: aload_3
    //   131: ldc 120
    //   133: bipush 36
    //   135: invokevirtual 118	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   138: pop
    //   139: new 122	com/tencent/mm/hellhoundlib/b/a
    //   142: dup
    //   143: invokespecial 123	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   146: aload_3
    //   147: invokevirtual 127	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   150: astore_2
    //   151: aload_1
    //   152: aload_2
    //   153: invokevirtual 131	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   156: ldc 133
    //   158: ldc 134
    //   160: ldc 136
    //   162: ldc 138
    //   164: ldc 140
    //   166: ldc 142
    //   168: invokestatic 148	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: aload_2
    //   173: iconst_0
    //   174: invokevirtual 152	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   177: checkcast 102	android/content/Intent
    //   180: invokevirtual 156	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   183: aload_1
    //   184: ldc 133
    //   186: ldc 134
    //   188: ldc 136
    //   190: ldc 138
    //   192: ldc 140
    //   194: ldc 142
    //   196: invokestatic 160	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   199: ldc 38
    //   201: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: return
    //   205: iconst_0
    //   206: istore 4
    //   208: goto -136 -> 72
    //   211: astore_1
    //   212: ldc 165
    //   214: aload_1
    //   215: ldc 167
    //   217: iconst_0
    //   218: anewarray 169	java/lang/Object
    //   221: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc 38
    //   226: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	g
    //   0	230	1	paramj	com.tencent.mm.view.recyclerview.j
    //   0	230	2	paramView	android.view.View
    //   0	230	3	paramk	k
    //   70	137	4	i	int
    // Exception table:
    //   from	to	target	type
    //   77	199	211	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.g
 * JD-Core Version:    0.7.0.1
 */