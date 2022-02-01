package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.a.bk;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.OnlineUser;
import com.tencent.mm.plugin.game.autogen.chatroom.Slot;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.b.e;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatMemberListView
  extends MRecyclerView
{
  private long Ijq;
  private long Ijr;
  public JumpInfo IlV;
  private String Ima;
  public b Iog;
  private c Ioh;
  private Set<String> Ioi;
  private Map<String, c> Ioj;
  public JumpInfo Iok;
  private Slot Iol;
  private com.tencent.mm.plugin.game.chatroom.b.e Iom;
  private Context mContext;
  
  public ChatMemberListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276278);
    this.Ioi = new HashSet();
    this.Ioj = new HashMap();
    this.Iol = new Slot();
    init(paramContext);
    AppMethodBeat.o(276278);
  }
  
  public ChatMemberListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276285);
    this.Ioi = new HashSet();
    this.Ioj = new HashMap();
    this.Iol = new Slot();
    init(paramContext);
    AppMethodBeat.o(276285);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(276291);
    this.mContext = paramContext;
    this.Ijr = ((Activity)paramContext).getIntent().getLongExtra("game_report_sourceid", 0L);
    this.Ijq = ((Activity)paramContext).getIntent().getLongExtra("game_report_ssid", 0L);
    paramContext = new LinearLayoutManager();
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    this.Ioh = new c();
    this.Ioh.a(this.mContext, this);
    setItemViewCacheSize(15);
    this.Iog = new b((byte)0);
    setAdapter(this.Iog);
    AppMethodBeat.o(276291);
  }
  
  public final boolean bs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(276369);
    c localc = this.Ioh;
    localc.am(localc.EK(localc.biT + paramInt1), false);
    boolean bool = super.bs(paramInt1, paramInt2);
    AppMethodBeat.o(276369);
    return bool;
  }
  
  public void setChatRoomName(String paramString)
  {
    AppMethodBeat.i(276360);
    if (this.Iol == null) {
      this.Iol = new Slot();
    }
    this.Iol.slot_type = 1;
    OnlineUser localOnlineUser = new OnlineUser();
    localOnlineUser.status = 1L;
    LinkedList localLinkedList = new LinkedList();
    ChatroomUserData localChatroomUserData = new ChatroomUserData();
    localChatroomUserData.username = "all";
    localChatroomUserData.chatroom_name = paramString;
    localLinkedList.add(localChatroomUserData);
    localOnlineUser.chat_user_data.addAll(localLinkedList);
    this.Iol.online_user_status = localOnlineUser;
    AppMethodBeat.o(276360);
  }
  
  public void setPremadeCardInfo(String paramString)
  {
    this.Ima = paramString;
  }
  
  public void setStateChangeListener(com.tencent.mm.plugin.game.chatroom.b.e parame)
  {
    this.Iom = parame;
  }
  
  final class a
    extends g.a
  {
    private List<Slot> uoj;
    private List<Slot> uok;
    
    public a(List<Slot> paramList)
    {
      this.uoj = paramList;
      Object localObject;
      this.uok = localObject;
    }
    
    public final int If()
    {
      AppMethodBeat.i(276468);
      int i = this.uoj.size();
      AppMethodBeat.o(276468);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(276472);
      int i = this.uok.size();
      AppMethodBeat.o(276472);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276482);
      Object localObject2 = (Slot)this.uoj.get(paramInt1);
      Object localObject1 = (Slot)this.uok.get(paramInt2);
      if ((((Slot)localObject2).online_user_status == null) || (Util.isNullOrNil(((Slot)localObject2).online_user_status.chat_user_data)) || (((Slot)localObject1).online_user_status == null) || (Util.isNullOrNil(((Slot)localObject1).online_user_status.chat_user_data)))
      {
        AppMethodBeat.o(276482);
        return false;
      }
      localObject2 = (ChatroomUserData)((Slot)localObject2).online_user_status.chat_user_data.get(0);
      localObject1 = (ChatroomUserData)((Slot)localObject1).online_user_status.chat_user_data.get(0);
      Util.nullAsNil(((ChatroomUserData)localObject2).username).equals(((ChatroomUserData)localObject1).username);
      AppMethodBeat.o(276482);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276489);
      Slot localSlot1 = (Slot)this.uoj.get(paramInt1);
      Slot localSlot2 = (Slot)this.uok.get(paramInt2);
      if ((localSlot1.online_user_status == null) || (localSlot2.online_user_status == null))
      {
        AppMethodBeat.o(276489);
        return false;
      }
      if ((localSlot1.slot_type == localSlot2.slot_type) && (localSlot1.online_user_status.status == localSlot2.online_user_status.status) && (localSlot1.online_user_status.chat_user_data.size() == localSlot2.online_user_status.chat_user_data.size()))
      {
        AppMethodBeat.o(276489);
        return true;
      }
      AppMethodBeat.o(276489);
      return false;
    }
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    private List<Slot> Ioo;
    
    private b()
    {
      AppMethodBeat.i(276479);
      this.Ioo = new LinkedList();
      AppMethodBeat.o(276479);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276504);
      int i = this.Ioo.size();
      AppMethodBeat.o(276504);
      return i;
    }
    
    public final void setData(List<Slot> paramList)
    {
      for (;;)
      {
        int j;
        try
        {
          AppMethodBeat.i(276500);
          if (paramList == null)
          {
            AppMethodBeat.o(276500);
            return;
          }
          j = 0;
          localObject = new HashMap();
          Iterator localIterator1 = paramList.iterator();
          if (!localIterator1.hasNext()) {
            break label194;
          }
          OnlineUser localOnlineUser = ((Slot)localIterator1.next()).online_user_status;
          int i = j;
          if (localOnlineUser != null)
          {
            i = j;
            if (localOnlineUser.status == 2L)
            {
              i = j;
              if (!Util.isNullOrNil(localOnlineUser.chat_user_data))
              {
                j += 1;
                Iterator localIterator2 = localOnlineUser.chat_user_data.iterator();
                i = j;
                if (localIterator2.hasNext())
                {
                  ChatroomUserData localChatroomUserData = (ChatroomUserData)localIterator2.next();
                  b.e locale = new b.e();
                  locale.iconUrl = localOnlineUser.status_icon;
                  locale.Ieg = localOnlineUser.icon_color;
                  ((Map)localObject).put(localChatroomUserData.username, locale);
                  continue;
                }
              }
            }
          }
          j = i;
        }
        finally {}
        continue;
        label194:
        if (ChatMemberListView.b(ChatMemberListView.this) != null)
        {
          ChatMemberListView.b(ChatMemberListView.this).ap((Map)localObject);
          ChatMemberListView.b(ChatMemberListView.this).Xg(j);
        }
        paramList.add(ChatMemberListView.c(ChatMemberListView.this));
        Object localObject = new LinkedList();
        ((List)localObject).addAll(this.Ioo);
        this.Ioo.clear();
        this.Ioo.addAll(paramList);
        g.a(new ChatMemberListView.a(ChatMemberListView.this, (List)localObject, this.Ioo)).a(this);
        AppMethodBeat.o(276500);
      }
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener, View.OnLongClickListener
    {
      JumpInfo Imo;
      ImageView Ior;
      ImageView Ios;
      TextView Iot;
      ViewGroup Iou;
      View Iov;
      TextView Iow;
      ImageView Iox;
      ImageView Ioy;
      ChatroomUserData Ioz;
      int position;
      ImageView yBT;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(276434);
        this.Ior = ((ImageView)paramView.findViewById(h.e.Igw));
        this.Ios = ((ImageView)paramView.findViewById(h.e.Igx));
        this.Iot = ((TextView)paramView.findViewById(h.e.IeH));
        this.yBT = ((ImageView)paramView.findViewById(h.e.icon_iv));
        this.Iot.setOnClickListener(this);
        this.yBT.setOnClickListener(this);
        this.yBT.setOnLongClickListener(this);
        this.Iou = ((ViewGroup)paramView.findViewById(h.e.Ihs));
        this.Iov = paramView.findViewById(h.e.Ihu);
        this.Iow = ((TextView)paramView.findViewById(h.e.Iht));
        this.Iox = ((ImageView)paramView.findViewById(h.e.Ihr));
        this.Ioy = ((ImageView)paramView.findViewById(h.e.Igt));
        AppMethodBeat.o(276434);
      }
      
      private void Xj(int paramInt)
      {
        AppMethodBeat.i(276441);
        long l;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276441);
          return;
        case 1: 
          l = 6L;
        }
        for (;;)
        {
          if (this.Ioz != null) {
            d.mty.a(this.position + 1, l, ChatMemberListView.i(ChatMemberListView.this), ChatMemberListView.j(ChatMemberListView.this), this.Ioz.username);
          }
          AppMethodBeat.o(276441);
          return;
          l = 7L;
          continue;
          l = 28L;
        }
      }
      
      final void a(Color paramColor)
      {
        AppMethodBeat.i(276453);
        if (paramColor != null)
        {
          paramColor = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil(paramColor.dark_color));
          if (paramColor != null)
          {
            GradientDrawable localGradientDrawable = (GradientDrawable)this.Iov.getBackground();
            if (localGradientDrawable != null) {
              localGradientDrawable.setColor(paramColor.intValue());
            }
          }
        }
        AppMethodBeat.o(276453);
      }
      
      public final void onClick(View paramView)
      {
        for (;;)
        {
          try
          {
            AppMethodBeat.i(276462);
            b localb = new b();
            localb.cH(paramView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((this.Ioz != null) && ("all".equals(this.Ioz.username)) && (!com.tencent.mm.plugin.game.chatroom.e.aFq(this.Ioz.chatroom_name).IdU))
            {
              Xj(com.tencent.mm.plugin.game.chatroom.e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.f(ChatMemberListView.this), 0, null));
              a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276462);
              return;
            }
            if ((this.Ioz != null) && (!com.tencent.mm.plugin.game.chatroom.e.aFq(this.Ioz.chatroom_name).IdU))
            {
              if ((this.Imo != null) && (this.Imo.jump_type == 1) && (ChatMemberListView.g(ChatMemberListView.this) != null) && (!Util.isNullOrNil(ChatMemberListView.g(ChatMemberListView.this).jump_url)) && (Util.nullAsNil(ChatMemberListView.g(ChatMemberListView.this).preload_id).equals(this.Imo.preload_id))) {
                h.a(ChatMemberListView.g(ChatMemberListView.this).jump_url, new h.b()
                {
                  public final void at(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(276217);
                    Log.i("GameChatRoom.ChatMemberListView", "checkPreload,  hasPreload:[%b], result[%b]", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
                    Object localObject;
                    if (paramAnonymousBoolean1) {
                      localObject = new JSONObject();
                    }
                    try
                    {
                      ((JSONObject)localObject).put("user_name", ChatMemberListView.b.a.this.Ioz.username);
                      ((JSONObject)localObject).put("user_data", f.dg(ChatMemberListView.b.a.this.Ioz).toString());
                      ((JSONObject)localObject).put("raw_url", ChatMemberListView.b.a.this.Imo.jump_url);
                      ((JSONObject)localObject).put("source_id", 1302L);
                      if (ChatMemberListView.h(ChatMemberListView.this) != null) {
                        ((JSONObject)localObject).put("premade_info", ChatMemberListView.h(ChatMemberListView.this));
                      }
                      label148:
                      localObject = URLEncoder.encode(((JSONObject)localObject).toString());
                      int i = com.tencent.mm.plugin.game.chatroom.e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.g(ChatMemberListView.this), 12, (String)localObject);
                      Log.i("GameChatRoom.ChatMemberListView", "use preload personal profile url: %s", new Object[] { ChatMemberListView.g(ChatMemberListView.this).jump_url });
                      for (;;)
                      {
                        ChatMemberListView.b.a.a(ChatMemberListView.b.a.this, i);
                        AppMethodBeat.o(276217);
                        return;
                        int j = com.tencent.mm.plugin.game.chatroom.e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.b.a.this.Imo, 0, null);
                        i = j;
                        if (ChatMemberListView.b.a.this.Imo != null)
                        {
                          Log.i("GameChatRoom.ChatMemberListView", "slot jump url: %s", new Object[] { ChatMemberListView.b.a.this.Imo.jump_url });
                          i = j;
                        }
                      }
                    }
                    catch (JSONException localJSONException)
                    {
                      break label148;
                    }
                  }
                });
              }
            }
            else
            {
              a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(276462);
              continue;
            }
            Xj(com.tencent.mm.plugin.game.chatroom.e.a(ChatMemberListView.a(ChatMemberListView.this), this.Imo, 0, null));
          }
          finally {}
          if (this.Imo != null) {
            Log.i("GameChatRoom.ChatMemberListView", "slot jump url: %s", new Object[] { this.Imo.jump_url });
          }
        }
      }
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(276467);
        b localb = new b();
        localb.cH(paramView);
        a.c("com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if ((this.Ioz != null) && (!"all".equals(this.Ioz.username)) && (!com.tencent.mm.plugin.game.chatroom.e.aFq(this.Ioz.chatroom_name).IdU) && (!com.tencent.mm.plugin.game.chatroom.e.aFq(this.Ioz.chatroom_name).IdV))
        {
          paramView = new bk();
          paramView.hBw.userName = this.Ioz.username;
          paramView.hBw.nickName = this.Ioz.nickname;
          paramView.publish();
          d.mty.a(this.position + 1, 27L, ChatMemberListView.i(ChatMemberListView.this), ChatMemberListView.j(ChatMemberListView.this), this.Ioz.username);
        }
        a.a(true, this, "com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(276467);
        return true;
      }
    }
  }
  
  final class c
  {
    long IoB;
    int dtB = 0;
    
    private c() {}
  }
  
  final class d
  {
    Runnable IoC;
    ValueAnimator animator;
    String userName;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView
 * JD-Core Version:    0.7.0.1
 */