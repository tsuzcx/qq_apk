package com.tencent.mm.plugin.game.chatroom.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.AbstractInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.BanAction;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomTag;
import com.tencent.mm.plugin.game.autogen.chatroom.ChattingInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.ContentBlock;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomNotice;
import com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule;
import com.tencent.mm.plugin.game.autogen.chatroom.ShowIcon;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class b
{
  private static v IpJ;
  private static MTimerHandler IpK;
  
  static
  {
    AppMethodBeat.i(276361);
    IpK = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(276374);
        b.fDt();
        AppMethodBeat.o(276374);
        return true;
      }
    }, false);
    AppMethodBeat.o(276361);
  }
  
  public static int a(Context paramContext, int paramInt, ChatroomData paramChatroomData, Lbs paramLbs, View paramView, List<BanAction> paramList, long paramLong)
  {
    AppMethodBeat.i(276342);
    if (!Util.isNullOrNil(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BanAction localBanAction = (BanAction)paramList.next();
        if (localBanAction.type == 1)
        {
          aS(paramContext, localBanAction.desc);
          AppMethodBeat.o(276342);
          return 0;
        }
      }
    }
    if ((paramChatroomData == null) || (Util.isNullOrNil(paramChatroomData.chatroom_name)))
    {
      AppMethodBeat.o(276342);
      return 0;
    }
    paramList = null;
    if (paramView != null) {
      paramList = ActivityOptions.makeScaleUpAnimation(paramView, paramView.getWidth() / 2, paramView.getHeight() / 2, 0, 0);
    }
    paramView = new Bundle();
    paramView.putString("chat_room_title", paramChatroomData.room_name);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(276342);
      return 0;
    case 1: 
      com.tencent.mm.plugin.game.chatroom.e.a(paramContext, paramChatroomData.apply_jump_info, 0, null);
      AppMethodBeat.o(276342);
      return 2;
    case 2: 
      ((com.tencent.mm.plugin.game.chatroom.a.a)h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, true, 0L, paramLong, paramView, paramList, false);
      AppMethodBeat.o(276342);
      return 1;
    case 3: 
      ((com.tencent.mm.plugin.game.chatroom.a.a)h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, false, 0L, paramLong, paramView, paramList, false);
      AppMethodBeat.o(276342);
      return 1;
    }
    if ((!paramChatroomData.is_private) && (paramChatroomData.can_onlooker))
    {
      ((com.tencent.mm.plugin.game.chatroom.a.a)h.az(com.tencent.mm.plugin.game.chatroom.a.a.class)).enterGameChatRoom(paramContext, paramChatroomData.chatroom_name, paramChatroomData.chatroom_icon, paramLbs, false, 0L, paramLong, paramView, paramList, false);
      AppMethodBeat.o(276342);
      return 1;
    }
    com.tencent.mm.plugin.game.chatroom.e.a(paramContext, paramChatroomData.apply_jump_info, 0, null);
    AppMethodBeat.o(276342);
    return 2;
  }
  
  public static ChatroomData a(com.tencent.mm.plugin.game.chatroom.d.a parama)
  {
    if (parama != null)
    {
      parama = parama.Ikc;
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
  
  public static void aS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(276354);
    fDt();
    IpJ = k.a((Activity)paramContext, h.g.tipsbar_icon_warning, paramContext.getResources().getColor(h.b.transparent), paramString, 0, null);
    IpK.startTimer(5000L, 0L);
    AppMethodBeat.o(276354);
  }
  
  public static void fDt()
  {
    AppMethodBeat.i(276347);
    if ((IpJ != null) && (IpJ.isShowing())) {
      IpJ.dismiss();
    }
    IpJ = null;
    AppMethodBeat.o(276347);
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
    private long InY;
    private TextView IoS;
    private ImageView IoT;
    private View IoU;
    private TextView IoV;
    private MyChatroomInfo IoW;
    private View IpL;
    private ImageView IpM;
    private TextView IpN;
    private ChatroomData IpO;
    private Lbs IpP;
    private int position;
    private long ssid;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(276225);
      this.IoS = ((TextView)paramView.findViewById(h.e.Iff));
      this.IoT = ((ImageView)paramView.findViewById(h.e.Ifc));
      this.IpL = paramView.findViewById(h.e.Ihe);
      this.IoU = paramView.findViewById(h.e.gbj);
      this.IoV = ((TextView)paramView.findViewById(h.e.IeZ));
      this.IpM = ((ImageView)paramView.findViewById(h.e.Ifi));
      this.IpN = ((TextView)paramView.findViewById(h.e.Ifj));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276410);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$MyChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          JSONObject localJSONObject;
          if ((b.b.a(b.b.this) != null) && (b.b.a(b.b.this).chatroom_info != null) && (b.b.a(b.b.this).chatroom_info.chatroom_data != null)) {
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("reportStr", b.b.a(b.b.this).chatroom_info.chatroom_data.report_str);
            label106:
            int i = b.a(b.b.this.mContext, 3, b.b.a(b.b.this).chatroom_info.chatroom_data, b.b.b(b.b.this), b.b.c(b.b.this), null, 1001L);
            label175:
            d.a locala;
            if (b.b.d(b.b.this) == null)
            {
              paramAnonymousView = "";
              if (b.b.d(b.b.this) != null) {
                break label256;
              }
              localObject = "";
              if (i != 1) {
                break label270;
              }
              locala = d.mty;
              d.a.a(1001L, b.b.e(b.b.this), 6L, 0L, b.b.f(b.b.this), b.b.g(b.b.this), paramAnonymousView, (String)localObject, localJSONObject.toString());
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$MyChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276410);
              return;
              paramAnonymousView = b.b.d(b.b.this).appid;
              break;
              label256:
              localObject = b.b.d(b.b.this).chatroom_name;
              break label175;
              label270:
              if (i == 2)
              {
                locala = d.mty;
                d.a.a(1001L, b.b.e(b.b.this), 7L, 0L, b.b.f(b.b.this), b.b.g(b.b.this), paramAnonymousView, (String)localObject, localJSONObject.toString());
              }
            }
          }
          catch (Exception paramAnonymousView)
          {
            break label106;
          }
        }
      });
      AppMethodBeat.o(276225);
    }
    
    public final void a(com.tencent.mm.plugin.game.chatroom.d.a parama, Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList)
    {
      AppMethodBeat.i(276288);
      if (!(parama.Ikc instanceof MyChatroomInfo))
      {
        AppMethodBeat.o(276288);
        return;
      }
      this.IoW = ((MyChatroomInfo)parama.Ikc);
      this.IpP = paramLbs;
      this.position = paramInt;
      this.ssid = paramLong1;
      this.InY = paramLong2;
      if (this.IoW.unread_msg_count > 0L)
      {
        this.IoU.setVisibility(0);
        paramList = new StringBuilder();
        int i = 0;
        paramLbs = null;
        parama = paramLbs;
        paramInt = i;
        if (this.IoW.abstract_info != null)
        {
          parama = paramLbs;
          paramInt = i;
          if (!Util.isNullOrNil(this.IoW.abstract_info.abstract_desc))
          {
            paramList.append(this.IoW.abstract_info.abstract_desc);
            paramList.append(" ");
            i = paramList.length();
            parama = paramLbs;
            paramInt = i;
            if (this.IoW.abstract_info.word_color != null)
            {
              if (!aw.isDarkMode()) {
                break label505;
              }
              parama = this.IoW.abstract_info.word_color.dark_color;
              label193:
              parama = com.tencent.mm.plugin.game.chatroom.e.aFs(parama);
              paramInt = i;
            }
          }
        }
        if (Util.isNullOrNil(this.IoW.last_msg_desc)) {
          break label522;
        }
        paramList.append(this.IoW.last_msg_desc);
      }
      for (;;)
      {
        paramLbs = parama;
        if (parama == null) {
          paramLbs = Integer.valueOf(this.mContext.getResources().getColor(h.b.red_bg_color));
        }
        parama = new SpannableString(paramList);
        parama.setSpan(new ForegroundColorSpan(paramLbs.intValue()), 0, paramInt, 33);
        this.IoV.setText(parama);
        this.IpL.setVisibility(8);
        if ((this.IoW.chatroom_info != null) && (this.IoW.chatroom_info.chatroom_data != null))
        {
          this.IpO = this.IoW.chatroom_info.chatroom_data;
          this.IoS.setText(this.IoW.chatroom_info.chatroom_data.room_name);
          com.tencent.mm.plugin.game.d.e.fIb().p(this.IoT, this.IoW.chatroom_info.chatroom_data.chatroom_icon);
          if (this.IpO.top_chatroom) {
            this.IpL.setVisibility(0);
          }
        }
        if ((this.IoW.chatroom_info == null) || (this.IoW.chatroom_info.chating_des == null)) {
          break label659;
        }
        this.IpN.setText(this.IoW.chatroom_info.chating_des.desc);
        if (Util.isNullOrNil(this.IoW.chatroom_info.chating_des.avator)) {
          break label650;
        }
        com.tencent.mm.plugin.game.d.e.fIb().p(this.IpM, this.IoW.chatroom_info.chating_des.avator);
        this.IpM.setVisibility(0);
        AppMethodBeat.o(276288);
        return;
        this.IoU.setVisibility(8);
        break;
        label505:
        parama = this.IoW.abstract_info.word_color.light_color;
        break label193;
        label522:
        if ((this.IoW.chatroom_info != null) && (this.IoW.chatroom_info.last_chatroom_msg != null))
        {
          paramLbs = this.IoW.chatroom_info.last_chatroom_msg;
          if ((paramLbs != null) && (paramLbs.msg_content != null) && (paramLbs.msg_content.chatroom_text != null)) {}
          for (paramLbs = paramLbs.msg_content.chatroom_text.content;; paramLbs = "")
          {
            paramList.append(paramLbs);
            break;
          }
        }
        if ((this.IoW.chatroom_info != null) && (this.IoW.chatroom_info.chatroom_data != null)) {
          paramList.append(this.IoW.chatroom_info.chatroom_data.announcement);
        }
      }
      label650:
      this.IpM.setVisibility(8);
      label659:
      AppMethodBeat.o(276288);
    }
  }
  
  public static final class c
    extends b.a
  {
    private boolean Ikd;
    private long InY;
    private TextView IoS;
    private ImageView IoT;
    private ImageView IpM;
    private TextView IpN;
    private ChatroomData IpO;
    private Lbs IpP;
    private ImageView IpR;
    private LinearLayout IpS;
    private LinearLayout IpT;
    private boolean IpU;
    private List<BanAction> IpV;
    Map<Object, c> Ipp;
    private TextView nmm;
    private int position;
    private long ssid;
    private LinearLayout xsW;
    
    public c(final View paramView)
    {
      super();
      AppMethodBeat.i(276239);
      this.IpU = false;
      this.Ikd = false;
      this.IpV = new LinkedList();
      this.IoS = ((TextView)paramView.findViewById(h.e.Iff));
      this.IpR = ((ImageView)paramView.findViewById(h.e.Ifh));
      this.nmm = ((TextView)paramView.findViewById(h.e.IeW));
      this.IoT = ((ImageView)paramView.findViewById(h.e.Ifc));
      this.IpM = ((ImageView)paramView.findViewById(h.e.Ifi));
      this.IpN = ((TextView)paramView.findViewById(h.e.Ifj));
      this.IpS = ((LinearLayout)paramView.findViewById(h.e.IgQ));
      this.IpT = ((LinearLayout)paramView.findViewById(h.e.IgR));
      this.xsW = ((LinearLayout)paramView.findViewById(h.e.Ihd));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276263);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
            AppMethodBeat.o(276263);
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
      AppMethodBeat.o(276239);
    }
    
    private void in(List<ChatroomTag> paramList)
    {
      AppMethodBeat.i(276267);
      ArrayList localArrayList;
      final ChatroomTag localChatroomTag;
      View localView;
      Object localObject2;
      ImageView localImageView;
      if (!Util.isNullOrNil(paramList))
      {
        this.xsW.setVisibility(0);
        localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          localChatroomTag = (ChatroomTag)localIterator.next();
          localView = LayoutInflater.from(this.mContext).inflate(h.f.Iim, this.xsW, false);
          localObject2 = (TextView)localView.findViewById(h.e.Igo);
          localImageView = (ImageView)localView.findViewById(h.e.Ign);
          ((TextView)localObject2).setText(localChatroomTag.desc);
          if (localChatroomTag.color == null) {
            break label454;
          }
          if (aw.isDarkMode()) {
            paramList = localChatroomTag.color.dark_color;
          }
        }
      }
      label138:
      label296:
      label449:
      label454:
      for (paramList = com.tencent.mm.plugin.game.chatroom.e.aFs(paramList);; paramList = null)
      {
        Object localObject1 = paramList;
        if (paramList == null) {
          localObject1 = Integer.valueOf(this.mContext.getResources().getColor(h.b.FG_0));
        }
        ((TextView)localObject2).setTextColor(((Integer)localObject1).intValue());
        float f = com.tencent.mm.cd.a.getScaleSize(this.mContext);
        localImageView.getLayoutParams().height = ((int)(localImageView.getLayoutParams().height * f));
        localImageView.getLayoutParams().width = ((int)(f * localImageView.getLayoutParams().width));
        localImageView.requestLayout();
        if (!Util.isNullOrNil(localChatroomTag.icon))
        {
          localImageView.setVisibility(0);
          com.tencent.mm.plugin.game.d.e.fIb().p(localImageView, localChatroomTag.icon);
          localObject2 = (GradientDrawable)localView.getBackground();
          if (localObject2 != null)
          {
            if (localChatroomTag.background_color == null) {
              break label449;
            }
            if (!aw.isDarkMode()) {
              break label398;
            }
            paramList = localChatroomTag.background_color.dark_color;
          }
        }
        for (paramList = com.tencent.mm.plugin.game.chatroom.e.aFs(paramList);; paramList = null)
        {
          localObject1 = paramList;
          if (paramList == null) {
            localObject1 = Integer.valueOf(this.mContext.getResources().getColor(h.b.BG_1));
          }
          ((GradientDrawable)localObject2).setColor(((Integer)localObject1).intValue());
          localView.measure(0, 0);
          if (localChatroomTag.tag_jump_info != null) {
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(276281);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                com.tencent.mm.plugin.game.chatroom.e.a(b.c.this.mContext, localChatroomTag.tag_jump_info, 0, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(276281);
              }
            });
          }
          localArrayList.add(localView);
          break;
          paramList = localChatroomTag.color.light_color;
          break label138;
          localImageView.setVisibility(8);
          break label258;
          paramList = localChatroomTag.background_color.light_color;
          break label296;
          this.xsW.post(new b(localArrayList));
          AppMethodBeat.o(276267);
          return;
          this.xsW.setVisibility(8);
          AppMethodBeat.o(276267);
          return;
        }
      }
    }
    
    public final void a(com.tencent.mm.plugin.game.chatroom.d.a parama, final Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, final List<BanAction> paramList)
    {
      AppMethodBeat.i(276391);
      if (!(parama.Ikc instanceof ChatroomRecInfo))
      {
        AppMethodBeat.o(276391);
        return;
      }
      this.Ikd = parama.Ikd;
      if (paramList != null) {
        this.IpV.addAll(paramList);
      }
      paramList = (ChatroomRecInfo)parama.Ikc;
      this.IpP = paramLbs;
      this.position = paramInt;
      this.ssid = paramLong1;
      this.InY = paramLong2;
      this.caK.setTag(paramList);
      label236:
      Object localObject;
      if (paramList.chatroom_data != null)
      {
        this.IpO = paramList.chatroom_data;
        this.IoS.setText(paramList.chatroom_data.room_name);
        com.tencent.mm.plugin.game.d.e.fIb().p(this.IoT, paramList.chatroom_data.chatroom_icon);
        ArrayList localArrayList;
        label269:
        RestrictRule localRestrictRule;
        View localView;
        ImageView localImageView;
        if (paramList.chatroom_data.is_private)
        {
          this.nmm.setText(h.h.IiI);
          this.nmm.setTextColor(this.mContext.getResources().getColor(h.b.Link));
          this.IpR.setVisibility(0);
          this.nmm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(276276);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              Lbs localLbs;
              ImageView localImageView;
              List localList;
              if ((paramList != null) && (paramList.chatroom_data != null))
              {
                paramAnonymousView = b.c.this.mContext;
                localObject = paramList.chatroom_data;
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
                AppMethodBeat.o(276276);
                return;
              }
            }
          });
          if (!paramList.chatroom_data.can_join) {
            break label584;
          }
          this.nmm.setTextColor(this.mContext.getResources().getColor(h.b.Link));
          parama = paramList.chatroom_data.rule_list;
          if (Util.isNullOrNil(parama)) {
            break label993;
          }
          localArrayList = new ArrayList();
          localObject = parama.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label738;
          }
          localRestrictRule = (RestrictRule)((Iterator)localObject).next();
          localView = LayoutInflater.from(this.mContext).inflate(h.f.Iil, this.IpS, false);
          TextView localTextView = (TextView)localView.findViewById(h.e.Igm);
          localImageView = (ImageView)localView.findViewById(h.e.Igk);
          localTextView.setText(localRestrictRule.rule_desc);
          parama = null;
          if (localRestrictRule.color != null)
          {
            if (!aw.isDarkMode()) {
              break label620;
            }
            parama = localRestrictRule.color.dark_color;
            label372:
            parama = com.tencent.mm.plugin.game.chatroom.e.aFs(parama);
          }
          paramLbs = parama;
          if (parama == null)
          {
            if (!localRestrictRule.can_pass) {
              break label632;
            }
            paramLbs = Integer.valueOf(this.mContext.getResources().getColor(h.b.UN_Yellow_90));
          }
          label408:
          localTextView.setTextColor(paramLbs.intValue());
          float f = com.tencent.mm.cd.a.getScaleSize(this.mContext);
          localImageView.getLayoutParams().height = ((int)(localImageView.getLayoutParams().height * f));
          localImageView.getLayoutParams().width = ((int)(f * localImageView.getLayoutParams().width));
          localImageView.requestLayout();
          localImageView.setVisibility(0);
          if (localRestrictRule.show_icon == null) {
            break label674;
          }
          if (!aw.isDarkMode()) {
            break label652;
          }
          parama = localRestrictRule.show_icon.dark_icon;
          label502:
          if (Util.isNullOrNil(parama)) {
            break label664;
          }
          localImageView.setVisibility(0);
          com.tencent.mm.plugin.game.d.e.fIb().p(localImageView, parama);
        }
        for (;;)
        {
          localView.measure(0, 0);
          localArrayList.add(localView);
          break label269;
          this.nmm.setText(h.h.IiK);
          this.IpR.setVisibility(8);
          this.nmm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(276282);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RecommendChatRoomVH$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              Lbs localLbs;
              ImageView localImageView;
              List localList;
              if ((paramList != null) && (paramList.chatroom_data != null))
              {
                paramAnonymousView = b.c.this.mContext;
                localObject = paramList.chatroom_data;
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
                AppMethodBeat.o(276282);
                return;
              }
            }
          });
          break;
          label584:
          this.nmm.setTextColor(this.mContext.getResources().getColor(h.b.BW_0_Alpha_0_2));
          this.nmm.setClickable(false);
          this.IpU = true;
          break label236;
          label620:
          parama = localRestrictRule.color.light_color;
          break label372;
          label632:
          paramLbs = Integer.valueOf(this.mContext.getResources().getColor(h.b.FG_2));
          break label408;
          label652:
          parama = localRestrictRule.show_icon.light_icon;
          break label502;
          label664:
          localImageView.setVisibility(8);
          continue;
          label674:
          if (localRestrictRule.can_pass)
          {
            if (aw.isDarkMode()) {
              localImageView.setImageResource(h.g.chat_room_rule_pass_dark);
            } else {
              localImageView.setImageResource(h.g.chat_room_rule_pass_light);
            }
          }
          else if (aw.isDarkMode()) {
            localImageView.setImageResource(h.g.chat_room_rule_reject_dark);
          } else {
            localImageView.setImageResource(h.g.chat_room_rule_reject_light);
          }
        }
        label738:
        this.IpS.setVisibility(0);
        this.IpT.setVisibility(0);
        parama = (c)this.Ipp.get(paramList);
        paramLbs = (LinearLayout.LayoutParams)this.IpS.getLayoutParams();
        localObject = (LinearLayout.LayoutParams)this.IpT.getLayoutParams();
        if (parama == null) {
          break label977;
        }
        if (parama.Iqd == 0) {
          break label960;
        }
        paramLbs.height = parama.Iqd;
        if (parama.Iqe == 0) {
          break label968;
        }
        ((LinearLayout.LayoutParams)localObject).height = parama.Iqe;
        label827:
        this.IpS.setLayoutParams(paramLbs);
        this.IpT.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.IpS.removeAllViews();
        this.IpT.removeAllViews();
        this.IpS.post(new a(paramList, localArrayList));
      }
      for (;;)
      {
        in(paramList.chatroom_data.chatroom_tag_list);
        if (paramList.chating_des == null) {
          break label1023;
        }
        this.IpN.setText(paramList.chating_des.desc);
        if (Util.isNullOrNil(paramList.chating_des.avator)) {
          break label1014;
        }
        com.tencent.mm.plugin.game.d.e.fIb().p(this.IpM, paramList.chating_des.avator);
        this.IpM.setVisibility(0);
        AppMethodBeat.o(276391);
        return;
        label960:
        paramLbs.height = 0;
        break;
        label968:
        ((LinearLayout.LayoutParams)localObject).height = 0;
        break label827;
        label977:
        paramLbs.height = -2;
        ((LinearLayout.LayoutParams)localObject).height = -2;
        break label827;
        label993:
        this.IpS.setVisibility(8);
        this.IpT.setVisibility(8);
      }
      label1014:
      this.IpM.setVisibility(8);
      label1023:
      AppMethodBeat.o(276391);
    }
    
    final class a
      implements Runnable
    {
      private List<View> BvM;
      private int Iqb;
      private Object Iqc;
      
      a(List<View> paramList)
      {
        AppMethodBeat.i(276151);
        this.Iqb = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        this.BvM = new ArrayList();
        Collection localCollection;
        this.BvM.addAll(localCollection);
        this.Iqc = paramList;
        AppMethodBeat.o(276151);
      }
      
      public final void run()
      {
        AppMethodBeat.i(276163);
        int i1 = b.c.e(b.c.this).getMeasuredWidth();
        b.c.c localc = new b.c.c();
        Iterator localIterator = this.BvM.iterator();
        int i = 0;
        int j = 0;
        int k;
        int n;
        if (localIterator.hasNext())
        {
          View localView = (View)localIterator.next();
          if (localView.getMeasuredWidth() > i1) {}
          int m;
          for (k = i1;; k = localView.getMeasuredWidth())
          {
            m = j + k;
            if ((m > i1) || (i != 0)) {
              break label193;
            }
            b.c.e(b.c.this).addView(localView);
            localc.Iqd = localView.getMeasuredHeight();
            n = i;
            k = m;
            if (i1 - m < this.Iqb) {
              break label339;
            }
            localView = new View(b.c.this.mContext);
            b.c.e(b.c.this).addView(localView, new LinearLayout.LayoutParams(this.Iqb, 8));
            j = this.Iqb + m;
            break;
          }
          label193:
          j = i;
          if (i == 0)
          {
            j = 1;
            m = k;
          }
          if (m <= i1)
          {
            b.c.f(b.c.this).addView(localView);
            localc.Iqe = localView.getMeasuredHeight();
            n = j;
            k = m;
            if (i1 - m < this.Iqb) {
              break label339;
            }
            localView = new View(b.c.this.mContext);
            b.c.f(b.c.this).addView(localView, new LinearLayout.LayoutParams(this.Iqb, 8));
            k = m + this.Iqb;
            i = j;
          }
        }
        for (j = k;; j = k)
        {
          break;
          if (this.Iqc != null) {
            b.c.g(b.c.this).put(this.Iqc, localc);
          }
          AppMethodBeat.o(276163);
          return;
          label339:
          i = n;
        }
      }
    }
    
    final class b
      implements Runnable
    {
      private List<View> BvM;
      private int Iqb;
      
      b()
      {
        AppMethodBeat.i(276153);
        this.Iqb = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        this.BvM = new ArrayList();
        Collection localCollection;
        this.BvM.addAll(localCollection);
        AppMethodBeat.o(276153);
      }
      
      public final void run()
      {
        AppMethodBeat.i(276162);
        b.c.h(b.c.this).removeAllViews();
        int k = b.c.h(b.c.this).getMeasuredWidth();
        Iterator localIterator = this.BvM.iterator();
        int i = 0;
        View localView;
        int j;
        if (localIterator.hasNext())
        {
          localView = (View)localIterator.next();
          if (localView.getMeasuredWidth() > k)
          {
            j = k;
            label72:
            i += j;
            if (i > k) {
              break label163;
            }
            b.c.h(b.c.this).addView(localView);
            if (k - i < this.Iqb) {
              break label169;
            }
            localView = new View(b.c.this.mContext);
            b.c.h(b.c.this).addView(localView, new LinearLayout.LayoutParams(this.Iqb, 8));
            i = this.Iqb + i;
          }
        }
        label163:
        label169:
        for (;;)
        {
          break;
          j = localView.getMeasuredWidth();
          break label72;
          AppMethodBeat.o(276162);
          return;
        }
      }
    }
    
    public static final class c
    {
      int Iqd = 0;
      int Iqe = 0;
    }
  }
  
  public static final class d
    extends b.a
  {
    private long InY;
    private List<BanAction> IpV;
    private TextView Iqf;
    private View Iqg;
    private ImageView Iqh;
    private JumpInfo Iqi;
    private View Iqj;
    private MMNeat7extView Iqk;
    private View Iql;
    private Drawable Iqm;
    private boolean Iqn;
    private boolean Iqo;
    private long ssid;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(276235);
      this.Iqo = false;
      this.Iqf = ((TextView)paramView.findViewById(h.e.IgU));
      this.Iqg = paramView.findViewById(h.e.Ifz);
      this.Iqh = ((ImageView)paramView.findViewById(h.e.Ify));
      this.Iqg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276398);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!Util.isNullOrNil(b.d.a(b.d.this)))
          {
            paramAnonymousView = b.d.a(b.d.this).iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject = (BanAction)paramAnonymousView.next();
              if (((BanAction)localObject).type == 2)
              {
                b.aS(b.d.this.mContext, ((BanAction)localObject).desc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(276398);
                return;
              }
            }
          }
          com.tencent.mm.plugin.game.chatroom.e.a(b.d.this.mContext, b.d.b(b.d.this), 0, null);
          paramAnonymousView = d.mty;
          d.a.a(1003L, 2L, 7L, 0L, b.d.c(b.d.this), b.d.d(b.d.this), "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276398);
        }
      });
      this.Iqm = bb.m(this.mContext, h.g.game_add_icon, com.tencent.mm.cd.a.w(this.mContext, h.b.FG_0_CARE));
      this.Iqj = paramView.findViewById(h.e.IgO);
      this.Iqk = ((MMNeat7extView)paramView.findViewById(h.e.IgP));
      this.Iqk.setOnTouchListener(new l(this.Iqk, new s(this.Iqk.getContext())));
      this.Iql = paramView.findViewById(h.e.IgN);
      float f = com.tencent.mm.cd.a.getScaleSize(this.mContext);
      this.Iql.getLayoutParams().height = ((int)(this.Iql.getLayoutParams().height * f));
      this.Iql.getLayoutParams().width = ((int)(f * this.Iql.getLayoutParams().width));
      this.Iql.requestLayout();
      this.Iql.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(276394);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          b.d.e(b.d.this).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatRoomVH$RoomGroupVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276394);
        }
      });
      AppMethodBeat.o(276235);
    }
    
    public final void a(MyChatroomNotice paramMyChatroomNotice)
    {
      int i = 0;
      AppMethodBeat.i(276287);
      if (this.Iqo)
      {
        AppMethodBeat.o(276287);
        return;
      }
      this.Iqj.setVisibility(8);
      if ((this.Iqn) && (paramMyChatroomNotice != null) && (!Util.isNullOrNil(paramMyChatroomNotice.content_list)) && (paramMyChatroomNotice.bg_color != null))
      {
        if (aw.isDarkMode()) {}
        for (Object localObject1 = paramMyChatroomNotice.bg_color.dark_color;; localObject1 = paramMyChatroomNotice.bg_color.light_color)
        {
          localObject1 = com.tencent.mm.plugin.game.chatroom.e.aFs((String)localObject1);
          if (localObject1 != null) {
            break;
          }
          AppMethodBeat.o(276287);
          return;
        }
        Object localObject2 = (GradientDrawable)this.Iqj.getBackground();
        if (localObject2 == null)
        {
          AppMethodBeat.o(276287);
          return;
        }
        ((GradientDrawable)localObject2).setColor(((Integer)localObject1).intValue());
        this.Iqj.setVisibility(0);
        localObject1 = new SpannableStringBuilder();
        localObject2 = paramMyChatroomNotice.content_list.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          final ContentBlock localContentBlock = (ContentBlock)((Iterator)localObject2).next();
          if (!Util.isNullOrNil(localContentBlock.content))
          {
            paramMyChatroomNotice = localContentBlock.color;
            if (paramMyChatroomNotice == null)
            {
              paramMyChatroomNotice = null;
              label199:
              paramMyChatroomNotice = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(paramMyChatroomNotice));
              if (paramMyChatroomNotice == null) {
                continue;
              }
              ((SpannableStringBuilder)localObject1).append(localContentBlock.content);
              if (localContentBlock.jump_info != null) {
                break label287;
              }
              ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(paramMyChatroomNotice.intValue()), i, localContentBlock.content.length() + i, 33);
            }
            for (;;)
            {
              i = ((SpannableStringBuilder)localObject1).length();
              break;
              if (aw.isDarkMode())
              {
                paramMyChatroomNotice = paramMyChatroomNotice.dark_color;
                break label199;
              }
              paramMyChatroomNotice = paramMyChatroomNotice.light_color;
              break label199;
              label287:
              ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.messenger.a.a(localContentBlock)
              {
                public final void onClickImp(View paramAnonymousView)
                {
                  AppMethodBeat.i(276390);
                  com.tencent.mm.plugin.game.chatroom.e.a(b.d.this.mContext, localContentBlock.jump_info, 0, null);
                  b.d.e(b.d.this).setVisibility(8);
                  AppMethodBeat.o(276390);
                }
              }, i, localContentBlock.content.length() + i, 33);
            }
          }
        }
        this.Iqo = true;
        this.Iqk.aZ((CharSequence)localObject1);
      }
      AppMethodBeat.o(276287);
    }
    
    public final void a(com.tencent.mm.plugin.game.chatroom.d.a parama, Lbs paramLbs, int paramInt, long paramLong1, long paramLong2, List<BanAction> paramList)
    {
      boolean bool = true;
      AppMethodBeat.i(276274);
      this.ssid = paramLong1;
      this.InY = paramLong2;
      this.IpV = paramList;
      this.Iqi = parama.Ikf;
      if (parama.itemType == 1)
      {
        this.Iqf.setText(parama.Ike);
        if (this.Iqi == null) {
          break label123;
        }
        this.Iqh.setImageDrawable(this.Iqm);
        this.Iqg.setVisibility(0);
        label80:
        if (parama.itemType != 3) {
          break label135;
        }
      }
      for (;;)
      {
        this.Iqn = bool;
        AppMethodBeat.o(276274);
        return;
        if (parama.itemType != 3) {
          break;
        }
        this.Iqf.setText(parama.Ike);
        break;
        label123:
        this.Iqg.setVisibility(8);
        break label80;
        label135:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.b
 * JD-Core Version:    0.7.0.1
 */