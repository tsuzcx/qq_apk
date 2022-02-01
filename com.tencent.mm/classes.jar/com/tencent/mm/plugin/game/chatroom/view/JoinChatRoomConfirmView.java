package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomExternInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.RestrictRule;
import com.tencent.mm.plugin.game.chatroom.c.m;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class JoinChatRoomConfirmView
  extends LinearLayout
{
  private long InY;
  private TextView IrS;
  private LinearLayout IrT;
  private Context context;
  private TextView descTv;
  private TextView nmm;
  private long ssid;
  private ImageView yBT;
  
  public JoinChatRoomConfirmView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(276238);
    initView();
    AppMethodBeat.o(276238);
  }
  
  public JoinChatRoomConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276244);
    initView();
    AppMethodBeat.o(276244);
  }
  
  public JoinChatRoomConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276249);
    initView();
    AppMethodBeat.o(276249);
  }
  
  private View a(RestrictRule paramRestrictRule)
  {
    AppMethodBeat.i(276271);
    View localView = LayoutInflater.from(this.context).inflate(h.f.IhI, this, false);
    TextView localTextView = (TextView)localView.findViewById(h.e.Igm);
    ImageView localImageView = (ImageView)localView.findViewById(h.e.Igk);
    localTextView.setText(paramRestrictRule.rule_desc);
    float f = com.tencent.mm.cd.a.getScaleSize(getContext());
    localImageView.getLayoutParams().height = ((int)(localImageView.getLayoutParams().height * f));
    localImageView.getLayoutParams().width = ((int)(f * localImageView.getLayoutParams().width));
    localImageView.requestLayout();
    if (paramRestrictRule.can_pass)
    {
      localTextView.setTextColor(this.context.getResources().getColor(h.b.UN_Yellow_90));
      localImageView.setImageResource(h.g.chat_room_rule_pass_dark);
    }
    for (;;)
    {
      localView.measure(0, 0);
      AppMethodBeat.o(276271);
      return localView;
      localTextView.setTextColor(this.context.getResources().getColor(h.b.BW_100_Alpha_0_5));
      localImageView.setImageResource(h.g.chat_room_rule_reject_dark);
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(276259);
    this.context = getContext();
    LayoutInflater.from(this.context).inflate(h.f.Iig, this, true);
    this.IrS = ((TextView)findViewById(h.e.Igl));
    this.IrT = ((LinearLayout)findViewById(h.e.Igj));
    this.nmm = ((TextView)findViewById(h.e.Igf));
    this.yBT = ((ImageView)findViewById(h.e.Igp));
    this.descTv = ((TextView)findViewById(h.e.Igi));
    AppMethodBeat.o(276259);
  }
  
  public final void a(String paramString, final ChatroomData paramChatroomData, final ChatroomUserData paramChatroomUserData, final Lbs paramLbs, final JumpInfo paramJumpInfo, ChatroomExternInfo paramChatroomExternInfo)
  {
    AppMethodBeat.i(276308);
    if ((paramChatroomData == null) || (Util.isNullOrNil(paramString)) || (paramChatroomUserData == null))
    {
      AppMethodBeat.o(276308);
      return;
    }
    setVisibility(0);
    Object localObject = paramChatroomData.rule_list;
    if (!Util.isNullOrNil((List)localObject))
    {
      this.IrS.setVisibility(0);
      if (((List)localObject).size() <= 0) {
        break label414;
      }
    }
    label414:
    for (View localView = a((RestrictRule)((List)localObject).get(0));; localView = null)
    {
      if (((List)localObject).size() > 1) {}
      for (localObject = a((RestrictRule)((List)localObject).get(1));; localObject = null)
      {
        post(new a(localView, (View)localObject));
        for (;;)
        {
          com.tencent.mm.ui.i.a.a.g(this.yBT, paramString);
          paramString = (GradientDrawable)this.nmm.getBackground();
          if (!paramChatroomData.can_join) {
            break;
          }
          if ((!paramChatroomUserData.is_authorized) && (paramJumpInfo != null) && (!Util.isNullOrNil(paramJumpInfo.jump_url))) {
            com.tencent.mm.plugin.game.luggage.h.a(i.class, paramJumpInfo.jump_url, null);
          }
          d.mty.b(0L, 1L, 1L, this.ssid, this.InY);
          this.descTv.setText(h.h.IiX);
          paramString.setColor(this.context.getResources().getColor(h.b.UN_Brand));
          this.nmm.setTextColor(this.context.getResources().getColor(h.b.BW_BG_100));
          this.nmm.setClickable(true);
          this.nmm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(276512);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/view/JoinChatRoomConfirmView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              d.mty.b(1L, 13L, 0L, JoinChatRoomConfirmView.a(JoinChatRoomConfirmView.this), JoinChatRoomConfirmView.b(JoinChatRoomConfirmView.this));
              if (paramChatroomUserData.is_authorized)
              {
                paramAnonymousView = new m(paramChatroomData.chatroom_name, paramLbs, true, JoinChatRoomConfirmView.a(JoinChatRoomConfirmView.this), JoinChatRoomConfirmView.b(JoinChatRoomConfirmView.this));
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/chatroom/view/JoinChatRoomConfirmView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(276512);
                return;
                if (paramChatroomUserData.create_account_jump_info == null) {
                  continue;
                }
                if ((paramJumpInfo != null) && (!Util.isNullOrNil(paramJumpInfo.jump_url)) && (Util.nullAsNil(paramJumpInfo.preload_id).equals(paramChatroomUserData.create_account_jump_info.preload_id))) {
                  paramAnonymousView = new JSONObject();
                }
                try
                {
                  paramAnonymousView.put("source_id", 1311L);
                  label204:
                  paramAnonymousView = URLEncoder.encode(paramAnonymousView.toString());
                  e.a(JoinChatRoomConfirmView.c(JoinChatRoomConfirmView.this), paramChatroomUserData.create_account_jump_info, 11, paramAnonymousView);
                  continue;
                  e.a(JoinChatRoomConfirmView.c(JoinChatRoomConfirmView.this), paramChatroomUserData.create_account_jump_info, 11, null);
                }
                catch (JSONException localJSONException)
                {
                  break label204;
                }
              }
            }
          });
          AppMethodBeat.o(276308);
          return;
          this.IrS.setVisibility(8);
        }
        d.mty.b(0L, 1L, 2L, this.ssid, this.InY);
        if ((paramChatroomExternInfo != null) && (!Util.isNullOrNil(paramChatroomExternInfo.cannot_join_reason))) {
          this.descTv.setText(paramChatroomExternInfo.cannot_join_reason);
        }
        for (;;)
        {
          paramString.setColor(this.context.getResources().getColor(h.b.gallery_btn_disable_color));
          this.nmm.setTextColor(this.context.getResources().getColor(h.b.BW_100_Alpha_0_2));
          this.nmm.setClickable(false);
          AppMethodBeat.o(276308);
          return;
          this.descTv.setText(h.h.IiY);
        }
      }
    }
  }
  
  public final void aI(long paramLong1, long paramLong2)
  {
    this.ssid = paramLong1;
    this.InY = paramLong2;
  }
  
  final class a
    implements Runnable
  {
    private View IrY;
    private View IrZ;
    
    a(View paramView1, View paramView2)
    {
      this.IrY = paramView1;
      this.IrZ = paramView2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(276400);
      JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).removeAllViews();
      int i;
      int j;
      if (this.IrY != null)
      {
        i = this.IrY.getMeasuredWidth();
        if (this.IrZ == null) {
          break label125;
        }
        j = this.IrZ.getMeasuredWidth();
        label45:
        if (i + j <= JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).getMeasuredWidth()) {
          break label130;
        }
        JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).setOrientation(1);
      }
      for (;;)
      {
        if (this.IrY != null) {
          JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).addView(this.IrY);
        }
        if (this.IrZ != null) {
          JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).addView(this.IrZ);
        }
        AppMethodBeat.o(276400);
        return;
        i = 0;
        break;
        label125:
        j = 0;
        break label45;
        label130:
        JoinChatRoomConfirmView.d(JoinChatRoomConfirmView.this).setOrientation(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.JoinChatRoomConfirmView
 * JD-Core Version:    0.7.0.1
 */