package com.tencent.mm.plugin.game.chatroom.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.OnlineUser;
import com.tencent.mm.plugin.game.autogen.chatroom.Slot;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.f.e;
import com.tencent.mm.plugin.game.luggage.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatMemberListView
  extends MRecyclerView
{
  public b CwE;
  private c CwF;
  private Set<String> CwG;
  private Map<String, c> CwH;
  public JumpInfo CwI;
  public JumpInfo CwJ;
  private Slot CwK;
  private Context mContext;
  
  public ChatMemberListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211962);
    this.CwG = new HashSet();
    this.CwH = new HashMap();
    this.CwK = new Slot();
    init(paramContext);
    AppMethodBeat.o(211962);
  }
  
  public ChatMemberListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211964);
    this.CwG = new HashSet();
    this.CwH = new HashMap();
    this.CwK = new Slot();
    init(paramContext);
    AppMethodBeat.o(211964);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(211969);
    this.mContext = paramContext;
    paramContext = new LinearLayoutManager();
    paramContext.setOrientation(0);
    setLayoutManager(paramContext);
    this.CwF = new c();
    this.CwF.a(this.mContext, this);
    this.CwE = new b((byte)0);
    setAdapter(this.CwE);
    AppMethodBeat.o(211969);
  }
  
  public final boolean ay(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211968);
    c localc = this.CwF;
    localc.W(localc.Ek(localc.CL + paramInt1), false);
    boolean bool = super.ay(paramInt1, paramInt2);
    AppMethodBeat.o(211968);
    return bool;
  }
  
  public void setChatRoomName(String paramString)
  {
    AppMethodBeat.i(211967);
    if (this.CwK == null) {
      this.CwK = new Slot();
    }
    this.CwK.slot_type = 1;
    OnlineUser localOnlineUser = new OnlineUser();
    localOnlineUser.status = 1L;
    LinkedList localLinkedList = new LinkedList();
    ChatroomUserData localChatroomUserData = new ChatroomUserData();
    localChatroomUserData.username = "all";
    localChatroomUserData.chatroom_name = paramString;
    localLinkedList.add(localChatroomUserData);
    localOnlineUser.chat_user_data.addAll(localLinkedList);
    this.CwK.online_user_status = localOnlineUser;
    AppMethodBeat.o(211967);
  }
  
  public final class b
    extends RecyclerView.a<a>
  {
    public List<Slot> CwM;
    
    private b()
    {
      AppMethodBeat.i(212324);
      this.CwM = new LinkedList();
      AppMethodBeat.o(212324);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(212327);
      int i = this.CwM.size();
      AppMethodBeat.o(212327);
      return i;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      JumpInfo CvE;
      ImageView CwP;
      ImageView CwQ;
      TextView CwR;
      View CwS;
      TextView CwT;
      ImageView CwU;
      ChatroomUserData CwV;
      ImageView vpB;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(211380);
        paramView.setOnClickListener(this);
        this.CwP = ((ImageView)paramView.findViewById(f.e.Ctf));
        this.CwQ = ((ImageView)paramView.findViewById(f.e.Ctg));
        this.CwR = ((TextView)paramView.findViewById(f.e.Csf));
        this.vpB = ((ImageView)paramView.findViewById(f.e.icon_iv));
        this.CwS = paramView.findViewById(f.e.Ctz);
        this.CwT = ((TextView)paramView.findViewById(f.e.Cty));
        this.CwU = ((ImageView)paramView.findViewById(f.e.Ctx));
        AppMethodBeat.o(211380);
      }
      
      public final void onClick(View paramView)
      {
        for (;;)
        {
          try
          {
            AppMethodBeat.i(211381);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramView);
            a.c("com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((this.CwV != null) && ("all".equals(this.CwV.username)) && (!e.aIP(this.CwV.chatroom_name)))
            {
              e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.e(ChatMemberListView.this), 0, null);
              a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(211381);
              return;
            }
            if ((this.CwV != null) && (!e.aIP(this.CwV.chatroom_name)))
            {
              if ((this.CvE != null) && (this.CvE.jump_type == 1) && (ChatMemberListView.f(ChatMemberListView.this) != null) && (!Util.isNullOrNil(ChatMemberListView.f(ChatMemberListView.this).jump_url)) && (!com.tencent.mm.plugin.game.chatroom.b.CrK))
              {
                com.tencent.mm.plugin.game.chatroom.b.CrK = true;
                com.tencent.mm.plugin.game.luggage.h.a(ChatMemberListView.f(ChatMemberListView.this).jump_url, new h.b()
                {
                  public final void mi(boolean paramAnonymousBoolean)
                  {
                    AppMethodBeat.i(212450);
                    com.tencent.e.h.ZvG.n(new Runnable()
                    {
                      public final void run()
                      {
                        com.tencent.mm.plugin.game.chatroom.b.CrK = false;
                      }
                    }, 2000L);
                    Object localObject;
                    if (paramAnonymousBoolean) {
                      localObject = new JSONObject();
                    }
                    try
                    {
                      ((JSONObject)localObject).put("user_name", ChatMemberListView.b.a.this.CwV.username);
                      ((JSONObject)localObject).put("user_data", g.bN(ChatMemberListView.b.a.this.CwV).toString());
                      ((JSONObject)localObject).put("raw_url", ChatMemberListView.b.a.this.CvE.jump_url);
                      ((JSONObject)localObject).put("source_id", 1302L);
                      label101:
                      localObject = URLEncoder.encode(((JSONObject)localObject).toString());
                      e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.f(ChatMemberListView.this), 12, (String)localObject);
                      Log.i("GameChatRoom.ChatMemberListView", "use preload personal profile url: %s", new Object[] { ChatMemberListView.f(ChatMemberListView.this).jump_url });
                      AppMethodBeat.o(212450);
                      return;
                      e.a(ChatMemberListView.a(ChatMemberListView.this), ChatMemberListView.b.a.this.CvE, 0, null);
                      if (ChatMemberListView.b.a.this.CvE != null) {
                        Log.i("GameChatRoom.ChatMemberListView", "dont use preload personal profile url: %s, slot jump url: %s", new Object[] { ChatMemberListView.f(ChatMemberListView.this).jump_url, ChatMemberListView.b.a.this.CvE.jump_url });
                      }
                      AppMethodBeat.o(212450);
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      break label101;
                    }
                  }
                });
              }
            }
            else
            {
              a.a(this, "com/tencent/mm/plugin/game/chatroom/view/ChatMemberListView$ChatMemberAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(211381);
              continue;
            }
            e.a(ChatMemberListView.a(ChatMemberListView.this), this.CvE, 0, null);
          }
          finally {}
          if (this.CvE != null) {
            Log.i("GameChatRoom.ChatMemberListView", "slot jump url: %s", new Object[] { this.CvE.jump_url });
          }
        }
      }
    }
  }
  
  final class c
  {
    long CwY;
    int bAz = 0;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatMemberListView
 * JD-Core Version:    0.7.0.1
 */