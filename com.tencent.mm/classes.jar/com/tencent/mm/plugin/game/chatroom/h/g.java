package com.tencent.mm.plugin.game.chatroom.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.be;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.chatroom.b.b.a;
import com.tencent.mm.plugin.game.chatroom.c.j;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.f;
import com.tencent.mm.plugin.game.chatroom.f.g;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.plugin.game.luggage.h.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends RecyclerView.v
{
  protected long Cuy;
  protected long Cuz;
  private ViewGroup Cvd;
  private int Cve;
  protected ChatroomMsgPack Cvf;
  private ViewGroup Cvg;
  private View Cvh;
  private ImageView Cvi;
  private TextView Cvj;
  private TextView Cvk;
  private TextView Cvl;
  private ViewGroup Cvm;
  private ViewGroup Cvn;
  private ProgressBar Cvo;
  public ImageView Cvp;
  private com.tencent.mm.plugin.game.chatroom.b.c Cvq;
  private com.tencent.mm.plugin.game.chatroom.b.c Cvr;
  public long Cvs;
  String iZU;
  protected Context mContext;
  
  public g(View paramView, int paramInt)
  {
    super(paramView);
    AppMethodBeat.i(211233);
    this.Cvs = -1L;
    this.Cvd = ((ViewGroup)paramView);
    this.mContext = paramView.getContext();
    this.Cuz = ((Activity)this.mContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Cuy = ((Activity)this.mContext).getIntent().getLongExtra("game_report_ssid", 0L);
    this.Cve = com.tencent.mm.plugin.game.chatroom.d.Tq(paramInt);
    switch (this.Cve)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211233);
      return;
      LayoutInflater.from(this.mContext).inflate(f.f.CtG, this.Cvd, true);
      this.Cvg = ((ViewGroup)paramView.findViewById(f.e.Csn));
      this.Cvh = paramView.findViewById(f.e.Ctt);
      this.Cvi = ((ImageView)paramView.findViewById(f.e.Ctw));
      this.Cvj = ((TextView)paramView.findViewById(f.e.Ctu));
      this.Cvk = ((TextView)paramView.findViewById(f.e.CtA));
      this.Cvl = ((TextView)paramView.findViewById(f.e.Ctv));
      this.Cvm = ((ViewGroup)paramView.findViewById(f.e.Ctk));
      this.Cvn = ((ViewGroup)paramView.findViewById(f.e.Cth));
      this.Cvo = ((ProgressBar)paramView.findViewById(f.e.Ctj));
      this.Cvp = ((ImageView)paramView.findViewById(f.e.Cti));
      AppMethodBeat.o(211233);
      return;
      LayoutInflater.from(this.mContext).inflate(f.f.CtJ, this.Cvd, true);
      this.Cvg = ((ViewGroup)paramView.findViewById(f.e.Cso));
      AppMethodBeat.o(211233);
      return;
      LayoutInflater.from(this.mContext).inflate(f.f.CtI, this.Cvd, true);
      this.Cvg = ((ViewGroup)paramView.findViewById(f.e.Csm));
    }
  }
  
  protected void Tr(int paramInt) {}
  
  protected void a(ChatroomMsgPack paramChatroomMsgPack) {}
  
  public final void a(ChatroomMsgPack paramChatroomMsgPack, final com.tencent.mm.plugin.game.chatroom.b.c paramc, String paramString, final JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(211237);
    if ((paramChatroomMsgPack == null) || (Util.isNullOrNil(paramChatroomMsgPack.from_username)) || (paramc == null))
    {
      AppMethodBeat.o(211237);
      return;
    }
    this.Cvf = paramChatroomMsgPack;
    this.Cvr = paramc;
    this.iZU = paramString;
    paramc = new b(paramChatroomMsgPack);
    this.amk.setOnTouchListener(paramc);
    this.amk.setOnLongClickListener(paramc);
    switch (this.Cve)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211237);
      return;
      com.tencent.mm.ui.h.a.a.c(this.Cvi, this.Cvf.from_username);
      this.Cvi.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(210860);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          if ((g.b(g.this) != null) && (!e.aIP(g.this.iZU)))
          {
            paramAnonymousView = new be();
            paramAnonymousView.fwW.userName = g.this.Cvf.from_username;
            paramAnonymousView.fwW.nickName = g.b(g.this).getNickName();
            EventCenter.instance.publish(paramAnonymousView);
            paramAnonymousView = com.tencent.mm.game.report.d.jTj;
            d.a.a(4L, 27L, g.this.Cuy, g.this.Cuz, g.this.Cvf.seq, g.this.Cvf.from_username);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(210860);
          return true;
        }
      });
      this.Cvi.setOnClickListener(new View.OnClickListener()
      {
        /* Error */
        public final void onClick(View paramAnonymousView)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: ldc 29
          //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: new 37	com/tencent/mm/hellhoundlib/b/b
          //   10: dup
          //   11: invokespecial 38	com/tencent/mm/hellhoundlib/b/b:<init>	()V
          //   14: astore_2
          //   15: aload_2
          //   16: aload_1
          //   17: invokevirtual 42	com/tencent/mm/hellhoundlib/b/b:bn	(Ljava/lang/Object;)V
          //   20: ldc 44
          //   22: ldc 45
          //   24: ldc 46
          //   26: ldc 47
          //   28: aload_0
          //   29: aload_2
          //   30: invokevirtual 51	com/tencent/mm/hellhoundlib/b/b:aFi	()[Ljava/lang/Object;
          //   33: invokestatic 57	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
          //   36: aload_0
          //   37: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   40: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   43: ifnull +145 -> 188
          //   46: aload_0
          //   47: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   50: getfield 65	com/tencent/mm/plugin/game/chatroom/h/g:iZU	Ljava/lang/String;
          //   53: invokestatic 71	com/tencent/mm/plugin/game/chatroom/e:aIP	(Ljava/lang/String;)Z
          //   56: ifne +132 -> 188
          //   59: aload_0
          //   60: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   63: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   66: invokeinterface 77 1 0
          //   71: ifnull +137 -> 208
          //   74: aload_0
          //   75: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   78: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   81: invokeinterface 77 1 0
          //   86: getfield 83	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_type	I
          //   89: iconst_1
          //   90: if_icmpne +118 -> 208
          //   93: aload_0
          //   94: getfield 22	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvw	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   97: ifnull +111 -> 208
          //   100: aload_0
          //   101: getfield 22	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvw	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   104: getfield 86	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   107: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   110: ifne +98 -> 208
          //   113: getstatic 97	com/tencent/mm/plugin/game/chatroom/b:CrK	Z
          //   116: ifne +92 -> 208
          //   119: iconst_1
          //   120: putstatic 97	com/tencent/mm/plugin/game/chatroom/b:CrK	Z
          //   123: aload_0
          //   124: getfield 22	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvw	Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;
          //   127: getfield 86	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   130: new 10	com/tencent/mm/plugin/game/chatroom/h/g$4$1
          //   133: dup
          //   134: aload_0
          //   135: invokespecial 100	com/tencent/mm/plugin/game/chatroom/h/g$4$1:<init>	(Lcom/tencent/mm/plugin/game/chatroom/h/g$4;)V
          //   138: invokestatic 106	com/tencent/mm/plugin/game/luggage/h:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/game/luggage/h$b;)V
          //   141: getstatic 112	com/tencent/mm/game/report/d:jTj	Lcom/tencent/mm/game/report/d$a;
          //   144: astore_1
          //   145: ldc2_w 113
          //   148: ldc2_w 115
          //   151: aload_0
          //   152: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   155: getfield 120	com/tencent/mm/plugin/game/chatroom/h/g:Cuy	J
          //   158: aload_0
          //   159: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   162: getfield 123	com/tencent/mm/plugin/game/chatroom/h/g:Cuz	J
          //   165: aload_0
          //   166: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   169: getfield 127	com/tencent/mm/plugin/game/chatroom/h/g:Cvf	Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;
          //   172: getfield 132	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:seq	J
          //   175: aload_0
          //   176: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   179: getfield 127	com/tencent/mm/plugin/game/chatroom/h/g:Cvf	Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack;
          //   182: getfield 135	com/tencent/mm/plugin/game/autogen/chatroom/ChatroomMsgPack:from_username	Ljava/lang/String;
          //   185: invokestatic 140	com/tencent/mm/game/report/d$a:a	(JJJJJLjava/lang/String;)V
          //   188: aload_0
          //   189: ldc 44
          //   191: ldc 45
          //   193: ldc 46
          //   195: ldc 47
          //   197: invokestatic 143	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   200: ldc 29
          //   202: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   205: aload_0
          //   206: monitorexit
          //   207: return
          //   208: aload_0
          //   209: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   212: getfield 150	com/tencent/mm/plugin/game/chatroom/h/g:mContext	Landroid/content/Context;
          //   215: aload_0
          //   216: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   219: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   222: invokeinterface 77 1 0
          //   227: iconst_0
          //   228: aconst_null
          //   229: invokestatic 153	com/tencent/mm/plugin/game/chatroom/e:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;ILjava/lang/String;)I
          //   232: pop
          //   233: aload_0
          //   234: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   237: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   240: invokeinterface 77 1 0
          //   245: ifnull -104 -> 141
          //   248: ldc 155
          //   250: ldc 157
          //   252: iconst_1
          //   253: anewarray 4	java/lang/Object
          //   256: dup
          //   257: iconst_0
          //   258: aload_0
          //   259: getfield 20	com/tencent/mm/plugin/game/chatroom/h/g$4:Cvu	Lcom/tencent/mm/plugin/game/chatroom/h/g;
          //   262: invokestatic 61	com/tencent/mm/plugin/game/chatroom/h/g:b	(Lcom/tencent/mm/plugin/game/chatroom/h/g;)Lcom/tencent/mm/plugin/game/chatroom/b/c;
          //   265: invokeinterface 77 1 0
          //   270: getfield 86	com/tencent/mm/plugin/game/autogen/chatroom/JumpInfo:jump_url	Ljava/lang/String;
          //   273: aastore
          //   274: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   277: goto -136 -> 141
          //   280: astore_1
          //   281: aload_0
          //   282: monitorexit
          //   283: aload_1
          //   284: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	285	0	this	4
          //   0	285	1	paramAnonymousView	View
          //   14	16	2	localb	com.tencent.mm.hellhoundlib.b.b
          // Exception table:
          //   from	to	target	type
          //   2	141	280	finally
          //   141	188	280	finally
          //   188	205	280	finally
          //   208	277	280	finally
        }
      });
      ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.Cvf.from_username, new g.5(this));
      paramChatroomMsgPack = null;
      int i;
      switch (com.tencent.mm.plugin.game.chatroom.d.hC(this.Cvf.msg_type, this.Cvf.msg_sub_type))
      {
      default: 
        paramString = evF();
        if ((paramChatroomMsgPack != null) && (paramString != null))
        {
          paramChatroomMsgPack.removeAllViews();
          paramChatroomMsgPack.addView(paramString);
          a(this.Cvf);
          paramString.setOnClickListener(new g.6(this));
          paramString.setOnTouchListener(paramc);
          paramString.setOnLongClickListener(paramc);
        }
        this.Cvo.setVisibility(8);
        this.Cvp.setVisibility(8);
        if ((this.Cvf.msg_options != null) && (this.Cvf.msg_options.cli_local_data != null))
        {
          i = (int)(com.tencent.mm.b.o.Z(this.Cvf.msg_options.cli_local_data.toByteArray()) & 0xF);
          if (i != 1) {
            break label489;
          }
          this.Cvo.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        this.Cvp.setOnClickListener(new g.7(this));
        AppMethodBeat.o(211237);
        return;
        this.Cvm.setVisibility(0);
        this.Cvn.setVisibility(8);
        paramChatroomMsgPack = (RelativeLayout.LayoutParams)this.Cvh.getLayoutParams();
        paramChatroomMsgPack.addRule(6, f.e.Ctw);
        this.Cvh.setLayoutParams(paramChatroomMsgPack);
        paramChatroomMsgPack = this.Cvm;
        break;
        this.Cvm.setVisibility(8);
        this.Cvn.setVisibility(0);
        this.Cvh.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210764);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)g.h(g.this).getLayoutParams();
            localLayoutParams.topMargin = (g.i(g.this).getTop() + (g.i(g.this).getHeight() - g.h(g.this).getHeight()) / 2);
            g.h(g.this).setLayoutParams(localLayoutParams);
            AppMethodBeat.o(210764);
          }
        });
        paramChatroomMsgPack = this.Cvn;
        break;
        label489:
        if (i == 2) {
          this.Cvp.setVisibility(0);
        }
      }
      ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(this.Cvf.from_username, new b.a()
      {
        public final void ac(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramAnonymousMap)
        {
          AppMethodBeat.i(210914);
          if ((paramAnonymousMap != null) && (paramAnonymousMap.containsKey(g.this.Cvf.from_username)))
          {
            paramAnonymousMap = (com.tencent.mm.plugin.game.chatroom.b.c)paramAnonymousMap.get(g.this.Cvf.from_username);
            g.a(g.this, paramAnonymousMap);
          }
          paramAnonymousMap = g.this.evF();
          if ((g.a(g.this) != null) && (paramAnonymousMap != null))
          {
            g.a(g.this).removeAllViews();
            g.a(g.this).addView(paramAnonymousMap);
            g.this.a(g.this.Cvf);
            paramAnonymousMap.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(211652);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                g.this.evG();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(211652);
              }
            });
            paramAnonymousMap.setOnTouchListener(paramc);
            paramAnonymousMap.setOnLongClickListener(paramc);
          }
          AppMethodBeat.o(210914);
        }
      });
    }
  }
  
  protected void b(com.tencent.mm.ui.base.o paramo) {}
  
  protected View evF()
  {
    return null;
  }
  
  protected void evG() {}
  
  protected boolean evH()
  {
    return false;
  }
  
  public final void evI()
  {
    AppMethodBeat.i(211239);
    if ((this.Cvf == null) || (this.Cvf.seq != this.Cvs))
    {
      AppMethodBeat.o(211239);
      return;
    }
    GradientDrawable localGradientDrawable = (GradientDrawable)this.Cvg.getBackground();
    if (localGradientDrawable == null)
    {
      AppMethodBeat.o(211239);
      return;
    }
    localGradientDrawable.setColor(this.mContext.getResources().getColor(f.b.BW_100_Alpha_0_3));
    com.tencent.e.h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210763);
        g.this.evJ();
        AppMethodBeat.o(210763);
      }
    }, 3000L);
    AppMethodBeat.o(211239);
  }
  
  public final void evJ()
  {
    AppMethodBeat.i(211241);
    GradientDrawable localGradientDrawable = (GradientDrawable)this.Cvg.getBackground();
    if (localGradientDrawable != null) {
      localGradientDrawable.setColor(this.mContext.getResources().getColor(f.b.UN_BW_0_Alpha_0_3));
    }
    AppMethodBeat.o(211241);
  }
  
  final class b
    implements View.OnLongClickListener, View.OnTouchListener
  {
    private com.tencent.mm.ui.widget.b.a AYp;
    private ChatroomMsgPack CvB;
    private int syc;
    private int syd;
    
    public b(ChatroomMsgPack paramChatroomMsgPack)
    {
      this.CvB = paramChatroomMsgPack;
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(212156);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if ((e.aIP(g.this.iZU)) || (g.this.evH()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(212156);
        return true;
      }
      if (this.CvB != null)
      {
        localObject = com.tencent.mm.game.report.d.jTj;
        d.a.a(1L, 27L, g.this.Cuy, g.this.Cuz, this.CvB.seq, this.CvB.from_username);
      }
      this.AYp = new com.tencent.mm.ui.widget.b.a(paramView.getContext(), paramView);
      this.AYp.Yri = true;
      this.AYp.Yrg = new q.e()
      {
        public final void a(com.tencent.mm.ui.base.o paramAnonymouso, View paramAnonymousView)
        {
          AppMethodBeat.i(210916);
          if ((g.b(g.this) != null) && (g.b(g.this).evx()))
          {
            paramAnonymouso.b(9527, g.this.mContext.getString(f.h.Cug), f.g.icons_outlined_at);
            if (g.b.a(g.b.this) != null)
            {
              paramAnonymousView = com.tencent.mm.game.report.d.jTj;
              d.a.a(5L, 1L, g.this.Cuy, g.this.Cuz, g.b.a(g.b.this).seq, g.b.a(g.b.this).from_username);
            }
          }
          if ((g.b.a(g.b.this).msg_options != null) && (!Util.isNullOrNil(g.b.a(g.b.this).msg_options.complaint_url)) && (g.j(g.this) != null) && (!Util.nullAsNil(g.j(g.this).getUserName()).equals(g.b.a(g.b.this).from_username))) {
            paramAnonymouso.b(9528, g.this.mContext.getString(f.h.app_expose), f.g.icons_filled_report_problem);
          }
          if ((g.b(g.this) != null) && (g.b(g.this).evz()) && (g.j(g.this) != null) && (g.j(g.this).evy())) {
            paramAnonymouso.b(9529, g.this.mContext.getString(f.h.Cuh), f.g.icons_outlined_close);
          }
          g.this.b(paramAnonymouso);
          AppMethodBeat.o(210916);
        }
      };
      this.AYp.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(211634);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            g.this.Tr(paramAnonymousMenuItem.getItemId());
          case 9527: 
            do
            {
              AppMethodBeat.o(211634);
              return;
            } while ((g.b.a(g.b.this) == null) || (g.b(g.this) == null));
            paramAnonymousMenuItem = new be();
            paramAnonymousMenuItem.fwW.userName = g.b.a(g.b.this).from_username;
            paramAnonymousMenuItem.fwW.nickName = g.b(g.this).getNickName();
            EventCenter.instance.publish(paramAnonymousMenuItem);
            paramAnonymousMenuItem = com.tencent.mm.game.report.d.jTj;
            d.a.a(5L, 2L, g.this.Cuy, g.this.Cuz, g.b.a(g.b.this).seq, g.b.a(g.b.this).from_username);
            AppMethodBeat.o(211634);
            return;
          case 9528: 
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("rawUrl", g.b.a(g.b.this).msg_options.complaint_url);
            com.tencent.mm.by.c.b(g.this.mContext, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
            AppMethodBeat.o(211634);
            return;
          }
          paramAnonymousMenuItem = new f.a(g.this.mContext);
          paramAnonymousMenuItem.bBl(g.this.mContext.getString(f.h.Cun, new Object[] { g.b(g.this).getNickName() })).HL(true);
          paramAnonymousMenuItem.c(new f.c()
          {
            public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
            {
              AppMethodBeat.i(211001);
              if ((paramAnonymous2Boolean) && (g.b.a(g.b.this) != null))
              {
                paramAnonymous2String = new j(g.b.a(g.b.this).from_username);
                com.tencent.mm.kernel.h.aGY().a(paramAnonymous2String, 0);
              }
              AppMethodBeat.o(211001);
            }
          }).b(new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
          }).icF().show();
          AppMethodBeat.o(211634);
        }
      };
      if ((paramView.getTag(f.e.touch_loc) instanceof int[]))
      {
        paramView = (int[])paramView.getTag(f.e.touch_loc);
        this.AYp.eY(paramView[0], paramView[1]);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/game/chatroom/piece/GameChatItemVH$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(212156);
        return true;
        this.AYp.eY(this.syc, this.syd);
      }
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(212153);
      if (paramMotionEvent.getAction() == 0)
      {
        this.syc = ((int)paramMotionEvent.getRawX());
        this.syd = ((int)paramMotionEvent.getRawY());
      }
      AppMethodBeat.o(212153);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.g
 * JD-Core Version:    0.7.0.1
 */