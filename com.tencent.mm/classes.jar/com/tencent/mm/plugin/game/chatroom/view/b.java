package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.AbstractInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChattingInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule;
import com.tencent.mm.plugin.game.chatroom.f.b;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.chatroom.f.g;
import com.tencent.mm.plugin.game.chatroom.f.h;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static r CxK;
  private static MTimerHandler CxL;
  
  static
  {
    AppMethodBeat.i(210848);
    CxL = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(210874);
        b.evV();
        AppMethodBeat.o(210874);
        return true;
      }
    }, false);
    AppMethodBeat.o(210848);
  }
  
  public static int a(Context paramContext, int paramInt, ChatroomData paramChatroomData, Lbs paramLbs, View paramView, List<BanAction> paramList, long paramLong)
  {
    AppMethodBeat.i(210844);
    if (!Util.isNullOrNil(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BanAction localBanAction = (BanAction)paramList.next();
        if (localBanAction.type == 1)
        {
          aP(paramContext, localBanAction.desc);
          AppMethodBeat.o(210844);
          return 0;
        }
      }
    }
    if ((paramChatroomData == null) || (Util.isNullOrNil(paramChatroomData.chatroom_name)))
    {
      AppMethodBeat.o(210844);
      return 0;
    }
    paramList = null;
    if (paramView != null) {
      paramList = ActivityOptions.makeScaleUpAnimation(paramView, paramView.getWidth() / 2, paramView.getHeight() / 2, 0, 0);
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(210844);
      return 0;
    case 1: 
      com.tencent.mm.plugin.game.chatroom.e.a(paramContext, paramChatroomData.apply_jump_info, 0, null);
      AppMethodBeat.o(210844);
      return 2;
    case 2: 
      ((com.tencent.mm.plugin.game.chatroom.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, true, 0L, paramLong, paramList);
      AppMethodBeat.o(210844);
      return 1;
    case 3: 
      ((com.tencent.mm.plugin.game.chatroom.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, false, 0L, paramLong, paramList);
      AppMethodBeat.o(210844);
      return 1;
    }
    if ((!paramChatroomData.is_private) && (paramChatroomData.can_onlooker))
    {
      ((com.tencent.mm.plugin.game.chatroom.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, false, 0L, paramLong, paramList);
      AppMethodBeat.o(210844);
      return 1;
    }
    com.tencent.mm.plugin.game.chatroom.e.a(paramContext, paramChatroomData.apply_jump_info, 0, null);
    AppMethodBeat.o(210844);
    return 2;
  }
  
  public static ChatroomData a(com.tencent.mm.plugin.game.chatroom.d.a parama)
  {
    if (parama != null)
    {
      parama = parama.CuA;
      if ((parama instanceof MyChatroomInfo))
      {
        parama = (MyChatroomInfo)parama;
        if ((parama.chatroom_info != null) && (parama.chatroom_info.chatroom_data != null)) {
          return parama.chatroom_info.chatroom_data;
        }
      }
      else if ((parama instanceof ChatroomRecInfo))
      {
        parama = (ChatroomRecInfo)parama;
        if (parama.chatroom_data != null) {
          return parama.chatroom_data;
        }
      }
    }
    return null;
  }
  
  public static void aP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210847);
    evV();
    CxK = com.tencent.mm.ui.widget.a.h.a((Activity)paramContext, f.g.tipsbar_icon_warning, paramContext.getResources().getColor(f.b.transparent), paramString, 0, null);
    CxL.startTimer(5000L, 0L);
    AppMethodBeat.o(210847);
  }
  
  public static void evV()
  {
    AppMethodBeat.i(210845);
    if ((CxK != null) && (CxK.isShowing())) {
      CxK.dismiss();
    }
    CxK = null;
    AppMethodBeat.o(210845);
  }
  
  public static abstract class a
    extends RecyclerView.v
  {
    protected Context mContext;
    
    public a(View paramView)
    {
      super();
      this.mContext = paramView.getContext();
    }
    
    public abstract void a(com.tencent.mm.plugin.game.chatroom.d.a parama, Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList);
  }
  
  public static final class b
    extends b.a
  {
    private TextView CxM;
    private ImageView CxN;
    private View CxO;
    private TextView CxP;
    private ImageView CxQ;
    private TextView CxR;
    private MyChatroomInfo CxS;
    private ChatroomData CxT;
    private Lbs CxU;
    private long CxV;
    private int position;
    private long ssid;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(210911);
      this.CxM = ((TextView)paramView.findViewById(f.e.Csy));
      this.CxN = ((ImageView)paramView.findViewById(f.e.Csw));
      this.CxO = paramView.findViewById(f.e.dYv);
      this.CxP = ((TextView)paramView.findViewById(f.e.Cst));
      this.CxQ = ((ImageView)paramView.findViewById(f.e.CsA));
      this.CxR = ((TextView)paramView.findViewById(f.e.CsB));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212165);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$MyChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          int i;
          label142:
          d.a locala;
          if ((b.b.a(b.b.this) != null) && (b.b.a(b.b.this).chatroom_info != null) && (b.b.a(b.b.this).chatroom_info.chatroom_data != null))
          {
            i = b.a(b.b.this.mContext, 3, b.b.a(b.b.this).chatroom_info.chatroom_data, b.b.b(b.b.this), b.b.c(b.b.this), null, 1001L);
            if (b.b.d(b.b.this) != null) {
              break label206;
            }
            paramAnonymousView = "";
            if (b.b.d(b.b.this) != null) {
              break label220;
            }
            localObject = "";
            if (i != 1) {
              break label234;
            }
            locala = d.jTj;
            d.a.a(1001L, b.b.e(b.b.this), 6L, 0L, b.b.f(b.b.this), b.b.g(b.b.this), paramAnonymousView, (String)localObject, "");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$MyChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212165);
            return;
            label206:
            paramAnonymousView = b.b.d(b.b.this).appid;
            break;
            label220:
            localObject = b.b.d(b.b.this).chatroom_name;
            break label142;
            label234:
            if (i == 2)
            {
              locala = d.jTj;
              d.a.a(1001L, b.b.e(b.b.this), 7L, 0L, b.b.f(b.b.this), b.b.g(b.b.this), paramAnonymousView, (String)localObject, "");
            }
          }
        }
      });
      AppMethodBeat.o(210911);
    }
    
    public final void a(com.tencent.mm.plugin.game.chatroom.d.a parama, Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList)
    {
      AppMethodBeat.i(210913);
      if (!(parama.CuA instanceof MyChatroomInfo))
      {
        AppMethodBeat.o(210913);
        return;
      }
      this.CxS = ((MyChatroomInfo)parama.CuA);
      this.CxU = paramLbs;
      this.position = paramInt;
      this.ssid = paramLong1;
      this.CxV = paramLong2;
      int j;
      int i;
      if (this.CxS.unread_msg_count > 0L)
      {
        this.CxO.setVisibility(0);
        paramLbs = new StringBuilder();
        int k = 0;
        j = -1;
        paramInt = j;
        i = k;
        if (this.CxS.abstract_info != null)
        {
          paramInt = j;
          i = k;
          if (!Util.isNullOrNil(this.CxS.abstract_info.abstract_desc))
          {
            paramLbs.append(this.CxS.abstract_info.abstract_desc);
            paramLbs.append(" ");
            k = paramLbs.length();
            paramInt = j;
            i = k;
            if (this.CxS.abstract_info.word_color != null)
            {
              if (!ar.isDarkMode()) {
                break label479;
              }
              parama = this.CxS.abstract_info.word_color.dark_color;
              label196:
              paramInt = com.tencent.mm.plugin.game.chatroom.e.aIQ(parama);
              i = k;
            }
          }
        }
        if (Util.isNullOrNil(this.CxS.last_msg_desc)) {
          break label496;
        }
        paramLbs.append(this.CxS.last_msg_desc);
      }
      for (;;)
      {
        j = paramInt;
        if (paramInt == -1) {
          j = this.mContext.getResources().getColor(f.b.red_bg_color);
        }
        parama = new SpannableString(paramLbs);
        parama.setSpan(new ForegroundColorSpan(j), 0, i, 33);
        this.CxP.setText(parama);
        if ((this.CxS.chatroom_info != null) && (this.CxS.chatroom_info.chatroom_data != null))
        {
          this.CxT = this.CxS.chatroom_info.chatroom_data;
          this.CxM.setText(this.CxS.chatroom_info.chatroom_data.room_name);
          com.tencent.mm.plugin.game.d.e.eAa().o(this.CxN, this.CxS.chatroom_info.chatroom_data.chatroom_icon);
        }
        if ((this.CxS.chatroom_info == null) || (this.CxS.chatroom_info.chating_des == null)) {
          break label631;
        }
        this.CxR.setText(this.CxS.chatroom_info.chating_des.desc);
        if (Util.isNullOrNil(this.CxS.chatroom_info.chating_des.avator)) {
          break label622;
        }
        com.tencent.mm.plugin.game.d.e.eAa().o(this.CxQ, this.CxS.chatroom_info.chating_des.avator);
        this.CxQ.setVisibility(0);
        AppMethodBeat.o(210913);
        return;
        this.CxO.setVisibility(8);
        break;
        label479:
        parama = this.CxS.abstract_info.word_color.light_color;
        break label196;
        label496:
        if ((this.CxS.chatroom_info != null) && (this.CxS.chatroom_info.last_chatroom_msg != null))
        {
          parama = this.CxS.chatroom_info.last_chatroom_msg;
          if ((parama != null) && (parama.msg_content != null) && (parama.msg_content.chatroom_text != null)) {}
          for (parama = parama.msg_content.chatroom_text.content;; parama = "")
          {
            paramLbs.append(parama);
            break;
          }
        }
        if ((this.CxS.chatroom_info != null) && (this.CxS.chatroom_info.chatroom_data != null)) {
          paramLbs.append(this.CxS.chatroom_info.chatroom_data.announcement);
        }
      }
      label622:
      this.CxQ.setVisibility(8);
      label631:
      AppMethodBeat.o(210913);
    }
  }
  
  public static final class c
    extends b.a
  {
    private boolean CuB;
    private TextView CxM;
    private ImageView CxN;
    private ImageView CxQ;
    private TextView CxR;
    private ChatroomData CxT;
    private Lbs CxU;
    private long CxV;
    private ImageView CxX;
    private TextView CxY;
    private TextView CxZ;
    private ImageView Cya;
    private TextView Cyb;
    private ImageView Cyc;
    private boolean Cyd;
    private List<BanAction> Cye;
    private TextView kJW;
    private int position;
    private long ssid;
    
    public c(final View paramView)
    {
      super();
      AppMethodBeat.i(212664);
      this.Cyd = false;
      this.CuB = false;
      this.Cye = new LinkedList();
      this.CxM = ((TextView)paramView.findViewById(f.e.Csy));
      this.CxX = ((ImageView)paramView.findViewById(f.e.Csz));
      this.kJW = ((TextView)paramView.findViewById(f.e.Csq));
      this.CxN = ((ImageView)paramView.findViewById(f.e.Csw));
      this.CxQ = ((ImageView)paramView.findViewById(f.e.CsA));
      this.CxR = ((TextView)paramView.findViewById(f.e.CsB));
      this.CxY = ((TextView)paramView.findViewById(f.e.Ctn));
      this.CxZ = ((TextView)paramView.findViewById(f.e.CsL));
      this.Cya = ((ImageView)paramView.findViewById(f.e.CsK));
      this.Cyb = ((TextView)paramView.findViewById(f.e.Ctr));
      this.Cyc = ((ImageView)paramView.findViewById(f.e.Ctq));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(211252);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          long l;
          int i;
          if ((paramView.getTag() instanceof ChatroomRecInfo))
          {
            localObject = (ChatroomRecInfo)paramView.getTag();
            if ((localObject != null) && (((ChatroomRecInfo)localObject).chatroom_data != null))
            {
              paramAnonymousView = b.c.this.mContext;
              localObject = ((ChatroomRecInfo)localObject).chatroom_data;
              Lbs localLbs = b.c.a(b.c.this);
              ImageView localImageView = b.c.b(b.c.this);
              List localList = b.c.c(b.c.this);
              if (!b.c.d(b.c.this)) {
                break label179;
              }
              l = 1102L;
              i = b.a(paramAnonymousView, 4, (ChatroomData)localObject, localLbs, localImageView, localList, l);
              if (i != 1) {
                break label186;
              }
              i = 3;
            }
          }
          for (;;)
          {
            b.c.a(b.c.this, i);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(211252);
            return;
            label179:
            l = 1002L;
            break;
            label186:
            if (i == 2) {
              i = 1;
            } else {
              i = 3;
            }
          }
        }
      });
      AppMethodBeat.o(212664);
    }
    
    private void a(TextView paramTextView, ImageView paramImageView, RestrictRule paramRestrictRule)
    {
      AppMethodBeat.i(212674);
      paramTextView.setText(paramRestrictRule.rule_desc);
      paramTextView.setVisibility(0);
      paramImageView.setVisibility(0);
      if (paramRestrictRule.can_pass)
      {
        paramTextView.setTextColor(this.mContext.getResources().getColor(f.b.Yellow_90));
        if (ar.isDarkMode())
        {
          paramImageView.setImageResource(f.g.chat_room_rule_pass_dark);
          AppMethodBeat.o(212674);
          return;
        }
        paramImageView.setImageResource(f.g.chat_room_rule_pass_light);
        AppMethodBeat.o(212674);
        return;
      }
      paramTextView.setTextColor(this.mContext.getResources().getColor(f.b.FG_2));
      if (ar.isDarkMode())
      {
        paramImageView.setImageResource(f.g.chat_room_rule_reject_dark);
        AppMethodBeat.o(212674);
        return;
      }
      paramImageView.setImageResource(f.g.chat_room_rule_reject_light);
      AppMethodBeat.o(212674);
    }
    
    public final void a(final com.tencent.mm.plugin.game.chatroom.d.a parama, final Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList)
    {
      AppMethodBeat.i(212669);
      if (!(parama.CuA instanceof ChatroomRecInfo))
      {
        AppMethodBeat.o(212669);
        return;
      }
      this.CuB = parama.CuB;
      if (paramList != null) {
        this.Cye.addAll(paramList);
      }
      parama = (ChatroomRecInfo)parama.CuA;
      this.CxU = paramLbs;
      this.position = paramInt;
      this.ssid = paramLong1;
      this.CxV = paramLong2;
      this.amk.setTag(parama);
      if (parama.chatroom_data != null)
      {
        this.CxT = parama.chatroom_data;
        this.CxM.setText(parama.chatroom_data.room_name);
        com.tencent.mm.plugin.game.d.e.eAa().o(this.CxN, parama.chatroom_data.chatroom_icon);
        if (!parama.chatroom_data.is_private) {
          break label424;
        }
        this.kJW.setText(f.h.Cuj);
        this.kJW.setTextColor(this.mContext.getResources().getColor(f.b.Link));
        this.CxX.setVisibility(0);
        this.kJW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(211980);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            Lbs localLbs;
            ImageView localImageView;
            List localList;
            if ((parama != null) && (parama.chatroom_data != null))
            {
              paramAnonymousView = b.c.this.mContext;
              localObject = parama.chatroom_data;
              localLbs = paramLbs;
              localImageView = b.c.b(b.c.this);
              localList = b.c.c(b.c.this);
              if (!b.c.d(b.c.this)) {
                break label150;
              }
            }
            label150:
            for (long l = 1102L;; l = 1002L)
            {
              b.a(paramAnonymousView, 1, (ChatroomData)localObject, localLbs, localImageView, localList, l);
              b.c.a(b.c.this, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(211980);
              return;
            }
          }
        });
        if (!parama.chatroom_data.can_join) {
          break label463;
        }
        this.kJW.setTextColor(this.mContext.getResources().getColor(f.b.Link));
      }
      for (;;)
      {
        this.CxY.setVisibility(8);
        this.CxZ.setVisibility(8);
        this.Cya.setVisibility(8);
        this.Cyb.setVisibility(8);
        this.Cyc.setVisibility(8);
        paramLbs = parama.chatroom_data.rule_list;
        if (!Util.isNullOrNil(paramLbs))
        {
          this.CxY.setVisibility(0);
          if (paramLbs.size() > 0) {
            a(this.CxZ, this.Cya, (RestrictRule)paramLbs.get(0));
          }
          if (paramLbs.size() > 1) {
            a(this.Cyb, this.Cyc, (RestrictRule)paramLbs.get(1));
          }
        }
        if (parama.chating_des == null) {
          break label508;
        }
        this.CxR.setText(parama.chating_des.desc);
        if (Util.isNullOrNil(parama.chating_des.avator)) {
          break label499;
        }
        com.tencent.mm.plugin.game.d.e.eAa().o(this.CxQ, parama.chating_des.avator);
        this.CxQ.setVisibility(0);
        AppMethodBeat.o(212669);
        return;
        label424:
        this.kJW.setText(f.h.Cul);
        this.CxX.setVisibility(8);
        this.kJW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(210792);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            Lbs localLbs;
            ImageView localImageView;
            List localList;
            if ((parama != null) && (parama.chatroom_data != null))
            {
              paramAnonymousView = b.c.this.mContext;
              localObject = parama.chatroom_data;
              localLbs = paramLbs;
              localImageView = b.c.b(b.c.this);
              localList = b.c.c(b.c.this);
              if (!b.c.d(b.c.this)) {
                break label150;
              }
            }
            label150:
            for (long l = 1102L;; l = 1002L)
            {
              b.a(paramAnonymousView, 2, (ChatroomData)localObject, localLbs, localImageView, localList, l);
              b.c.a(b.c.this, 2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(210792);
              return;
            }
          }
        });
        break;
        label463:
        this.kJW.setTextColor(this.mContext.getResources().getColor(f.b.BW_0_Alpha_0_2));
        this.kJW.setClickable(false);
        this.Cyd = true;
      }
      label499:
      this.CxQ.setVisibility(8);
      label508:
      AppMethodBeat.o(212669);
    }
  }
  
  public static final class d
    extends b.a
  {
    private long CxV;
    private List<BanAction> Cye;
    private TextView Cyj;
    private View Cyk;
    private ImageView Cyl;
    private JumpInfo Cym;
    private Drawable Cyn;
    private long ssid;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(211094);
      this.Cyj = ((TextView)paramView.findViewById(f.e.Ctp));
      this.Cyk = paramView.findViewById(f.e.CsI);
      this.Cyl = ((ImageView)paramView.findViewById(f.e.CsH));
      this.Cyk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(210990);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (!Util.isNullOrNil(b.d.a(b.d.this)))
          {
            paramAnonymousView = b.d.a(b.d.this).iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (BanAction)paramAnonymousView.next();
              if (((BanAction)localObject).type == 2)
              {
                b.aP(b.d.this.mContext, ((BanAction)localObject).desc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(210990);
                return;
              }
            }
          }
          com.tencent.mm.plugin.game.chatroom.e.a(b.d.this.mContext, b.d.b(b.d.this), 0, null);
          paramAnonymousView = d.jTj;
          d.a.a(1003L, 2L, 7L, 0L, b.d.c(b.d.this), b.d.d(b.d.this), "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210990);
        }
      });
      this.Cyn = au.o(this.mContext, f.g.game_add_icon, com.tencent.mm.ci.a.w(this.mContext, f.b.FG_1));
      AppMethodBeat.o(211094);
    }
    
    public final void a(com.tencent.mm.plugin.game.chatroom.d.a parama, Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList)
    {
      AppMethodBeat.i(211096);
      this.ssid = paramLong1;
      this.CxV = paramLong2;
      this.Cye = paramList;
      this.Cym = parama.CuD;
      if (parama.fNO == 1) {
        this.Cyj.setText(parama.CuC);
      }
      while (this.Cym != null)
      {
        this.Cyl.setImageDrawable(this.Cyn);
        this.Cyk.setVisibility(0);
        AppMethodBeat.o(211096);
        return;
        if (parama.fNO == 3) {
          this.Cyj.setText(parama.CuC);
        }
      }
      this.Cyk.setVisibility(8);
      AppMethodBeat.o(211096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.b
 * JD-Core Version:    0.7.0.1
 */