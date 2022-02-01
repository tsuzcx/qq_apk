package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.chatroom.ui.ChatRoomBaseUI;
import com.tencent.mm.plugin.game.chatroom.view.ChatRoomListView;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;

public class ChatRoomTabUI
  extends ChatRoomBaseUI
{
  private a IVp;
  private String IVq;
  private ChatTabTopArea IVr;
  private ChatRoomListView IVs;
  private long Ijq;
  private long Ijr;
  
  public ChatRoomTabUI()
  {
    AppMethodBeat.i(276700);
    this.IVp = new a(this);
    AppMethodBeat.o(276700);
  }
  
  public final long fCZ()
  {
    return 1099L;
  }
  
  public final long fDa()
  {
    return 10L;
  }
  
  public int getCustomBounceId()
  {
    return h.e.HWD;
  }
  
  public int getLayoutId()
  {
    return h.f.HYR;
  }
  
  public final long getSourceId()
  {
    return this.Ijr;
  }
  
  public final long getSsid()
  {
    return this.Ijq;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(276762);
    super.onBackPressed();
    this.IVp.onBackPressed();
    AppMethodBeat.o(276762);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(276774);
    super.onConfigurationChanged(paramConfiguration);
    this.IVp.dG();
    AppMethodBeat.o(276774);
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   9: invokevirtual 109	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnull +83 -> 99
    //   19: aload 5
    //   21: ldc 111
    //   23: invokevirtual 117	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   26: ifne +24 -> 50
    //   29: aload_0
    //   30: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   33: ldc 111
    //   35: aload_0
    //   36: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   39: ldc 119
    //   41: iconst_0
    //   42: invokevirtual 123	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   45: i2l
    //   46: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   49: pop
    //   50: aload 5
    //   52: ldc 129
    //   54: invokevirtual 117	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   57: ifne +14 -> 71
    //   60: aload_0
    //   61: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   64: ldc 129
    //   66: lconst_0
    //   67: invokevirtual 127	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   70: pop
    //   71: aload_0
    //   72: aload_0
    //   73: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   76: ldc 111
    //   78: lconst_0
    //   79: invokevirtual 133	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   82: putfield 81	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:Ijq	J
    //   85: aload_0
    //   86: aload_0
    //   87: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   90: ldc 129
    //   92: lconst_0
    //   93: invokevirtual 133	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   96: putfield 78	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:Ijr	J
    //   99: ldc 135
    //   101: astore 6
    //   103: aload_0
    //   104: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   107: ldc 137
    //   109: invokevirtual 141	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 7
    //   114: getstatic 147	com/tencent/mm/game/report/d:mty	Lcom/tencent/mm/game/report/d$a;
    //   117: astore 5
    //   119: ldc 135
    //   121: invokestatic 151	com/tencent/mm/game/report/d:EH	(Ljava/lang/String;)V
    //   124: aload 6
    //   126: astore 5
    //   128: aload 7
    //   130: invokestatic 156	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   133: ifne +63 -> 196
    //   136: ldc 158
    //   138: invokestatic 164	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   141: checkcast 158	com/tencent/mm/plugin/game/api/f
    //   144: invokeinterface 168 1 0
    //   149: aload 7
    //   151: invokevirtual 174	com/tencent/mm/plugin/game/model/s:aGL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/game/model/o;
    //   154: astore 7
    //   156: aload 6
    //   158: astore 5
    //   160: aload 7
    //   162: ifnull +34 -> 196
    //   165: aload 7
    //   167: invokevirtual 179	com/tencent/mm/plugin/game/model/o:fGp	()V
    //   170: aload 7
    //   172: getfield 183	com/tencent/mm/plugin/game/model/o:IEd	Lcom/tencent/mm/plugin/game/model/o$d;
    //   175: getfield 189	com/tencent/mm/plugin/game/model/o$d:IEs	Lcom/tencent/mm/plugin/game/model/o$a;
    //   178: getfield 194	com/tencent/mm/plugin/game/model/o$a:IEn	Ljava/lang/String;
    //   181: astore 5
    //   183: getstatic 147	com/tencent/mm/game/report/d:mty	Lcom/tencent/mm/game/report/d$a;
    //   186: astore 6
    //   188: aload 7
    //   190: getfield 197	com/tencent/mm/plugin/game/model/o:mNoticeId	Ljava/lang/String;
    //   193: invokestatic 151	com/tencent/mm/game/report/d:EH	(Ljava/lang/String;)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 199	com/tencent/mm/plugin/game/chatroom/ui/ChatRoomBaseUI:onCreate	(Landroid/os/Bundle;)V
    //   201: aload_0
    //   202: invokevirtual 103	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getIntent	()Landroid/content/Intent;
    //   205: ldc 201
    //   207: iconst_0
    //   208: invokevirtual 205	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   211: ifeq +13 -> 224
    //   214: aload_0
    //   215: getstatic 210	com/tencent/mm/ui/MMFragmentActivity$a:upW	I
    //   218: getstatic 213	com/tencent/mm/ui/MMFragmentActivity$a:upX	I
    //   221: invokevirtual 217	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:overridePendingTransition	(II)V
    //   224: aload_0
    //   225: invokestatic 223	com/tencent/mm/plugin/game/commlib/e/b:fM	(Ljava/lang/Object;)V
    //   228: aload_0
    //   229: invokevirtual 227	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getSupportActionBar	()Landroidx/appcompat/app/ActionBar;
    //   232: invokevirtual 232	androidx/appcompat/app/ActionBar:hide	()V
    //   235: aload_0
    //   236: getfield 39	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVp	Lcom/tencent/mm/plugin/game/ui/chat_tab/a;
    //   239: aload_0
    //   240: invokevirtual 236	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getContentView	()Landroid/view/View;
    //   243: new 6	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$1
    //   246: dup
    //   247: aload_0
    //   248: invokespecial 239	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$1:<init>	(Lcom/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI;)V
    //   251: invokevirtual 242	com/tencent/mm/plugin/game/ui/chat_tab/a:a	(Landroid/view/View;Lcom/tencent/mm/plugin/game/ui/chat_tab/c$a;)V
    //   254: aload_0
    //   255: getstatic 245	com/tencent/mm/plugin/game/h$e:HWC	I
    //   258: invokevirtual 249	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:findViewById	(I)Landroid/view/View;
    //   261: checkcast 251	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar
    //   264: astore_1
    //   265: aload_1
    //   266: getstatic 256	com/tencent/mm/plugin/game/h$i:Icp	I
    //   269: invokevirtual 259	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar:setTitle	(I)V
    //   272: aload_1
    //   273: new 8	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$2
    //   276: dup
    //   277: aload_0
    //   278: invokespecial 260	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$2:<init>	(Lcom/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI;)V
    //   281: invokevirtual 264	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar:setBackBtn	(Landroid/view/View$OnClickListener;)V
    //   284: getstatic 269	com/tencent/mm/plugin/game/h$h:icons_outlined_me	I
    //   287: istore_2
    //   288: new 10	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$3
    //   291: dup
    //   292: aload_0
    //   293: invokespecial 270	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI$3:<init>	(Lcom/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI;)V
    //   296: astore 6
    //   298: aload_1
    //   299: getfield 274	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar:ImI	Landroid/widget/ImageView;
    //   302: iconst_0
    //   303: invokevirtual 279	android/widget/ImageView:setVisibility	(I)V
    //   306: aload_1
    //   307: getfield 274	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar:ImI	Landroid/widget/ImageView;
    //   310: iload_2
    //   311: invokevirtual 282	android/widget/ImageView:setImageResource	(I)V
    //   314: aload_1
    //   315: getfield 274	com/tencent/mm/plugin/game/ui/chat_tab/CustomTabActionBar:ImI	Landroid/widget/ImageView;
    //   318: aload 6
    //   320: invokevirtual 285	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   323: aload_0
    //   324: new 287	com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea
    //   327: dup
    //   328: aload_0
    //   329: invokespecial 290	com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea:<init>	(Landroid/content/Context;)V
    //   332: putfield 292	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVr	Lcom/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea;
    //   335: aload_0
    //   336: aload_0
    //   337: getstatic 69	com/tencent/mm/plugin/game/h$e:HWD	I
    //   340: invokevirtual 249	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:findViewById	(I)Landroid/view/View;
    //   343: checkcast 294	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView
    //   346: putfield 47	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVs	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
    //   349: aload_0
    //   350: getfield 47	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVs	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
    //   353: aload_0
    //   354: getfield 292	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVr	Lcom/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea;
    //   357: invokevirtual 298	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:ev	(Landroid/view/View;)V
    //   360: aload_0
    //   361: getfield 47	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:IVs	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView;
    //   364: astore 6
    //   366: new 300	com/tencent/mm/autogen/a/kr
    //   369: dup
    //   370: invokespecial 301	com/tencent/mm/autogen/a/kr:<init>	()V
    //   373: astore_1
    //   374: aload_1
    //   375: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   378: iconst_1
    //   379: putfield 310	com/tencent/mm/autogen/a/kr$a:hAf	I
    //   382: aload_1
    //   383: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   386: ldc_w 312
    //   389: putfield 315	com/tencent/mm/autogen/a/kr$a:key	Ljava/lang/String;
    //   392: aload_1
    //   393: invokevirtual 319	com/tencent/mm/autogen/a/kr:publish	()Z
    //   396: pop
    //   397: aload_1
    //   398: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   401: getfield 323	com/tencent/mm/autogen/a/kr$a:value	[B
    //   404: astore 7
    //   406: aload 7
    //   408: invokestatic 326	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   411: ifne +44 -> 455
    //   414: new 328	com/tencent/mm/plugin/game/autogen/chatroom/GetCanJoinChatroomResponse
    //   417: dup
    //   418: invokespecial 329	com/tencent/mm/plugin/game/autogen/chatroom/GetCanJoinChatroomResponse:<init>	()V
    //   421: astore_1
    //   422: aload_1
    //   423: aload 7
    //   425: invokevirtual 333	com/tencent/mm/plugin/game/autogen/chatroom/GetCanJoinChatroomResponse:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   428: pop
    //   429: iconst_1
    //   430: istore_2
    //   431: aload_1
    //   432: ifnull +23 -> 455
    //   435: iload_2
    //   436: ifeq +19 -> 455
    //   439: ldc_w 335
    //   442: ldc_w 337
    //   445: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   448: aload 6
    //   450: aload_1
    //   451: iconst_1
    //   452: invokevirtual 345	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:a	(Lcom/tencent/mm/plugin/game/autogen/chatroom/GetCanJoinChatroomResponse;Z)V
    //   455: iconst_1
    //   456: istore_3
    //   457: iconst_1
    //   458: istore_2
    //   459: getstatic 351	com/tencent/mm/plugin/game/chatroom/j/a:Imu	Lcom/tencent/mm/plugin/game/chatroom/j/a;
    //   462: astore_1
    //   463: invokestatic 355	com/tencent/mm/plugin/game/chatroom/j/a:fCW	()Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;
    //   466: ifnull +224 -> 690
    //   469: getstatic 351	com/tencent/mm/plugin/game/chatroom/j/a:Imu	Lcom/tencent/mm/plugin/game/chatroom/j/a;
    //   472: astore_1
    //   473: invokestatic 355	com/tencent/mm/plugin/game/chatroom/j/a:fCW	()Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;
    //   476: astore_1
    //   477: ldc_w 335
    //   480: ldc_w 357
    //   483: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload_1
    //   487: ifnull +29 -> 516
    //   490: aload_1
    //   491: getfield 363	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:my_chatroom_info_list	Ljava/util/LinkedList;
    //   494: invokestatic 366	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   497: ifne +19 -> 516
    //   500: iload_2
    //   501: ifeq +15 -> 516
    //   504: aload 6
    //   506: getfield 370	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:IoZ	Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b;
    //   509: aload_1
    //   510: getfield 363	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:my_chatroom_info_list	Ljava/util/LinkedList;
    //   513: invokevirtual 376	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView$b:il	(Ljava/util/List;)V
    //   516: getstatic 351	com/tencent/mm/plugin/game/chatroom/j/a:Imu	Lcom/tencent/mm/plugin/game/chatroom/j/a;
    //   519: astore_1
    //   520: iconst_1
    //   521: invokestatic 379	com/tencent/mm/plugin/game/chatroom/j/a:setScene	(I)V
    //   524: getstatic 351	com/tencent/mm/plugin/game/chatroom/j/a:Imu	Lcom/tencent/mm/plugin/game/chatroom/j/a;
    //   527: aload 5
    //   529: invokevirtual 382	com/tencent/mm/plugin/game/chatroom/j/a:startService	(Ljava/lang/String;)V
    //   532: aload 6
    //   534: getfield 386	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:mContext	Landroid/content/Context;
    //   537: ldc_w 388
    //   540: invokestatic 394	com/tencent/mm/pluginsdk/permission/b:s	(Landroid/content/Context;Ljava/lang/String;)Z
    //   543: istore 4
    //   545: ldc_w 335
    //   548: ldc_w 396
    //   551: iconst_1
    //   552: anewarray 398	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: iload 4
    //   559: invokestatic 404	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   562: aastore
    //   563: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: iload 4
    //   568: ifeq +207 -> 775
    //   571: invokestatic 413	com/tencent/mm/modelgeo/d:bJl	()Lcom/tencent/mm/modelgeo/d;
    //   574: aload 6
    //   576: getfield 417	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:lsF	Lcom/tencent/mm/modelgeo/b$a;
    //   579: iconst_1
    //   580: iconst_0
    //   581: invokevirtual 420	com/tencent/mm/modelgeo/d:a	(Lcom/tencent/mm/modelgeo/b$a;ZZ)V
    //   584: bipush 22
    //   586: bipush 10
    //   588: invokestatic 425	com/tencent/mm/plugin/report/service/l:kK	(II)V
    //   591: invokestatic 429	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   594: invokevirtual 435	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   597: getstatic 441	com/tencent/mm/storage/at$a:acST	Lcom/tencent/mm/storage/at$a;
    //   600: lconst_0
    //   601: invokestatic 446	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   604: invokevirtual 452	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   607: checkcast 443	java/lang/Long
    //   610: invokestatic 456	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Long;)J
    //   613: lconst_0
    //   614: lcmp
    //   615: ifne +21 -> 636
    //   618: invokestatic 429	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   621: invokevirtual 435	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   624: getstatic 441	com/tencent/mm/storage/at$a:acST	Lcom/tencent/mm/storage/at$a;
    //   627: invokestatic 459	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   630: invokestatic 446	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   633: invokevirtual 463	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   636: getstatic 147	com/tencent/mm/game/report/d:mty	Lcom/tencent/mm/game/report/d$a;
    //   639: astore_1
    //   640: ldc2_w 60
    //   643: lconst_0
    //   644: lconst_0
    //   645: lconst_1
    //   646: lconst_0
    //   647: aload_0
    //   648: getfield 81	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:Ijq	J
    //   651: lconst_0
    //   652: invokestatic 468	com/tencent/mm/game/report/d$a:a	(JJJJJJJ)Lcom/tencent/mm/autogen/mmdata/rpt/hk;
    //   655: invokevirtual 473	com/tencent/mm/autogen/mmdata/rpt/hk:bMH	()Z
    //   658: pop
    //   659: aload_0
    //   660: invokevirtual 477	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getBounceView	()Lcom/tencent/mm/ui/widget/pulldown/f;
    //   663: ifnull +13 -> 676
    //   666: aload_0
    //   667: invokevirtual 477	com/tencent/mm/plugin/game/ui/chat_tab/ChatRoomTabUI:getBounceView	()Lcom/tencent/mm/ui/widget/pulldown/f;
    //   670: iconst_0
    //   671: invokeinterface 483 2 0
    //   676: ldc 99
    //   678: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   681: return
    //   682: astore_1
    //   683: aconst_null
    //   684: astore_1
    //   685: iconst_0
    //   686: istore_2
    //   687: goto -256 -> 431
    //   690: new 300	com/tencent/mm/autogen/a/kr
    //   693: dup
    //   694: invokespecial 301	com/tencent/mm/autogen/a/kr:<init>	()V
    //   697: astore_1
    //   698: aload_1
    //   699: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   702: iconst_1
    //   703: putfield 310	com/tencent/mm/autogen/a/kr$a:hAf	I
    //   706: aload_1
    //   707: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   710: ldc_w 485
    //   713: putfield 315	com/tencent/mm/autogen/a/kr$a:key	Ljava/lang/String;
    //   716: aload_1
    //   717: invokevirtual 319	com/tencent/mm/autogen/a/kr:publish	()Z
    //   720: pop
    //   721: aload_1
    //   722: getfield 305	com/tencent/mm/autogen/a/kr:hMp	Lcom/tencent/mm/autogen/a/kr$a;
    //   725: getfield 323	com/tencent/mm/autogen/a/kr$a:value	[B
    //   728: astore 7
    //   730: aload 7
    //   732: invokestatic 326	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   735: ifne +58 -> 793
    //   738: new 359	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom
    //   741: dup
    //   742: invokespecial 486	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:<init>	()V
    //   745: astore_1
    //   746: aload_1
    //   747: aload 7
    //   749: invokevirtual 487	com/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   752: pop
    //   753: iload_3
    //   754: istore_2
    //   755: ldc_w 335
    //   758: ldc_w 489
    //   761: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: goto -278 -> 486
    //   767: astore_1
    //   768: aconst_null
    //   769: astore_1
    //   770: iconst_0
    //   771: istore_2
    //   772: goto -17 -> 755
    //   775: aload 6
    //   777: invokevirtual 492	com/tencent/mm/plugin/game/chatroom/view/ChatRoomListView:fDp	()V
    //   780: goto -189 -> 591
    //   783: astore 7
    //   785: goto -15 -> 770
    //   788: astore 7
    //   790: goto -105 -> 685
    //   793: aconst_null
    //   794: astore_1
    //   795: iload_3
    //   796: istore_2
    //   797: goto -42 -> 755
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	ChatRoomTabUI
    //   0	800	1	paramBundle	android.os.Bundle
    //   287	510	2	i	int
    //   456	340	3	j	int
    //   543	24	4	bool	boolean
    //   12	516	5	localObject1	Object
    //   101	675	6	localObject2	Object
    //   112	636	7	localObject3	Object
    //   783	1	7	localIOException1	java.io.IOException
    //   788	1	7	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   414	422	682	java/io/IOException
    //   738	746	767	java/io/IOException
    //   746	753	783	java/io/IOException
    //   422	429	788	java/io/IOException
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(276764);
    super.onDestroy();
    d.a locala = d.mty;
    d.EH("");
    this.IVp.onDestroy();
    com.tencent.mm.plugin.game.commlib.e.b.fN(this);
    AppMethodBeat.o(276764);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(276759);
    super.onNewIntent(paramIntent);
    this.IVp.onNewIntent(paramIntent);
    AppMethodBeat.o(276759);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(276756);
    super.onPause();
    com.tencent.mm.plugin.game.chatroom.j.a locala = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    com.tencent.mm.plugin.game.chatroom.j.a.setScene(2);
    a.onPause();
    AppMethodBeat.o(276756);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(276753);
    super.onResume();
    com.tencent.mm.plugin.game.chatroom.j.a locala = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    com.tencent.mm.plugin.game.chatroom.j.a.setScene(1);
    this.IVp.onResume();
    this.IVr.IVA.fHH();
    AppMethodBeat.o(276753);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(276748);
    if (!getIntent().getBooleanExtra("disable_game_page_swipe", false))
    {
      AppMethodBeat.o(276748);
      return true;
    }
    AppMethodBeat.o(276748);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatRoomTabUI
 * JD-Core Version:    0.7.0.1
 */