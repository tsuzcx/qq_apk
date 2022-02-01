package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.BackgroundInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomEnterInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.Color;
import com.tencent.mm.plugin.game.autogen.chatroom.ContentBlock;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.autogen.chatroom.UserEnterOption;
import com.tencent.mm.plugin.game.chatroom.c.m;
import com.tencent.mm.plugin.game.chatroom.h.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/JoinRoomExternalConfirmView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sourceId", "", "ssid", "attachData", "", "enterInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomEnterInfo;", "chatRoomData", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomData;", "userData", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomUserData;", "lbs", "Lcom/tencent/mm/plugin/game/autogen/chatroom/Lbs;", "preloadCreateAccount", "Lcom/tencent/mm/plugin/game/autogen/chatroom/JumpInfo;", "initView", "parseBlockText", "Landroid/text/SpannableStringBuilder;", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ContentBlock;", "setSource", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JoinRoomExternalConfirmView
  extends LinearLayout
{
  private long InY;
  private long ssid;
  
  public JoinRoomExternalConfirmView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JoinRoomExternalConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public JoinRoomExternalConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276292);
    LayoutInflater.from(getContext()).inflate(h.f.Iih, (ViewGroup)this);
    AppMethodBeat.o(276292);
  }
  
  private static final void a(BackgroundInfo paramBackgroundInfo, JoinRoomExternalConfirmView paramJoinRoomExternalConfirmView)
  {
    AppMethodBeat.i(276320);
    kotlin.g.b.s.u(paramBackgroundInfo, "$this_run");
    kotlin.g.b.s.u(paramJoinRoomExternalConfirmView, "this$0");
    com.tencent.mm.plugin.game.d.e.fIb().a(null, paramBackgroundInfo.background_url, null, (e.b)new a(paramJoinRoomExternalConfirmView));
    AppMethodBeat.o(276320);
  }
  
  private static final void a(ChatroomData paramChatroomData, ChatroomUserData paramChatroomUserData, JoinRoomExternalConfirmView paramJoinRoomExternalConfirmView, ChatroomEnterInfo paramChatroomEnterInfo, Lbs paramLbs, JumpInfo paramJumpInfo, View paramView)
  {
    AppMethodBeat.i(276315);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramChatroomData);
    localb.cH(paramChatroomUserData);
    localb.cH(paramJoinRoomExternalConfirmView);
    localb.cH(paramChatroomEnterInfo);
    localb.cH(paramLbs);
    localb.cH(paramJumpInfo);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/view/JoinRoomExternalConfirmView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramJoinRoomExternalConfirmView, "this$0");
    if ((paramChatroomData == null) || (paramChatroomUserData == null))
    {
      a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/view/JoinRoomExternalConfirmView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276315);
      return;
    }
    paramView = d.mty;
    d.a.a(1L, 13L, 0L, paramJoinRoomExternalConfirmView.ssid, paramJoinRoomExternalConfirmView.InY, paramChatroomEnterInfo.report_str);
    if (paramChatroomUserData.is_authorized)
    {
      paramChatroomData = new m(paramChatroomData.chatroom_name, paramLbs, true, paramJoinRoomExternalConfirmView.ssid, paramJoinRoomExternalConfirmView.InY);
      h.aZW().a((p)paramChatroomData, 0);
    }
    for (;;)
    {
      a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/view/JoinRoomExternalConfirmView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276315);
      return;
      if (paramChatroomUserData.create_account_jump_info == null) {
        continue;
      }
      if ((paramJumpInfo != null) && (!Util.isNullOrNil(paramJumpInfo.jump_url)) && (kotlin.g.b.s.p(Util.nullAsNil(paramJumpInfo.preload_id), paramChatroomUserData.create_account_jump_info.preload_id))) {
        paramChatroomData = new JSONObject();
      }
      try
      {
        paramChatroomData.put("source_id", 1311L);
        label277:
        paramChatroomData = URLEncoder.encode(paramChatroomData.toString());
        kotlin.g.b.s.s(paramChatroomData, "encode(jsonObject.toString())");
        com.tencent.mm.plugin.game.chatroom.e.a(paramJoinRoomExternalConfirmView.getContext(), paramChatroomUserData.create_account_jump_info, 11, paramChatroomData);
        continue;
        com.tencent.mm.plugin.game.chatroom.e.a(paramJoinRoomExternalConfirmView.getContext(), paramChatroomUserData.create_account_jump_info, 11, null);
      }
      catch (JSONException paramChatroomEnterInfo)
      {
        break label277;
      }
    }
  }
  
  public final void aI(long paramLong1, long paramLong2)
  {
    this.ssid = paramLong1;
    this.InY = paramLong2;
  }
  
  public final void b(ChatroomEnterInfo paramChatroomEnterInfo, ChatroomData paramChatroomData, ChatroomUserData paramChatroomUserData, Lbs paramLbs, JumpInfo paramJumpInfo)
  {
    AppMethodBeat.i(276358);
    if (paramChatroomEnterInfo != null)
    {
      Object localObject1 = d.mty;
      d.a.a(0L, 1L, 1L, this.ssid, this.InY, paramChatroomEnterInfo.report_str);
      ((TextView)findViewById(h.e.Ifv)).setText((CharSequence)paramChatroomEnterInfo.title);
      TextView localTextView = (TextView)findViewById(h.e.confirm_desc);
      localObject1 = paramChatroomEnterInfo.content_list;
      kotlin.g.b.s.s(localObject1, "it.content_list");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      Object localObject2;
      if (localObject1 != null)
      {
        Iterator localIterator = ((LinkedList)localObject1).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          ContentBlock localContentBlock = (ContentBlock)localIterator.next();
          if (!Util.isNullOrNil(localContentBlock.content))
          {
            localObject1 = localContentBlock.color;
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((Color)localObject1).dark_color)
            {
              localObject2 = com.tencent.mm.plugin.game.chatroom.e.aFs(Util.nullAsNil((String)localObject1));
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = Integer.valueOf(getContext().getResources().getColor(h.b.BW_100_Alpha_0_8));
              }
              localSpannableStringBuilder.append((CharSequence)localContentBlock.content);
              localSpannableStringBuilder.setSpan(new ForegroundColorSpan(((Number)localObject1).intValue()), i, localContentBlock.content.length() + i, 33);
              i = localSpannableStringBuilder.length();
              break;
            }
          }
        }
      }
      localTextView.setText((CharSequence)localSpannableStringBuilder);
      localObject1 = paramChatroomEnterInfo.user_enter_option;
      if (localObject1 != null)
      {
        localObject2 = new e.a.a();
        ((e.a.a)localObject2).IYs = true;
        com.tencent.mm.plugin.game.d.e.fIb().a((ImageView)findViewById(h.e.Ihk), ((UserEnterOption)localObject1).avatar, ((e.a.a)localObject2).fIc());
        ((TextView)findViewById(h.e.IgH)).setText((CharSequence)((UserEnterOption)localObject1).option_desc);
      }
      ((Button)findViewById(h.e.Igg)).setText((CharSequence)paramChatroomEnterInfo.buttom_desc);
      ((Button)findViewById(h.e.Igg)).setOnClickListener(new JoinRoomExternalConfirmView..ExternalSyntheticLambda0(paramChatroomData, paramChatroomUserData, this, paramChatroomEnterInfo, paramLbs, paramJumpInfo));
      paramChatroomData = paramChatroomEnterInfo.background_info;
      if (paramChatroomData != null)
      {
        paramChatroomEnterInfo = ((ConstraintLayout)findViewById(h.e.Ifw)).getBackground();
        if (paramChatroomEnterInfo == null)
        {
          paramChatroomEnterInfo = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
          AppMethodBeat.o(276358);
          throw paramChatroomEnterInfo;
        }
        paramChatroomUserData = (GradientDrawable)paramChatroomEnterInfo;
        paramChatroomEnterInfo = paramChatroomData.color;
        if (paramChatroomEnterInfo != null) {
          break label488;
        }
      }
    }
    label488:
    for (paramChatroomEnterInfo = null;; paramChatroomEnterInfo = paramChatroomEnterInfo.dark_color)
    {
      paramChatroomUserData.setColor(com.tencent.mm.plugin.game.chatroom.e.fo(paramChatroomEnterInfo, h.b.Dark_5));
      postDelayed(new JoinRoomExternalConfirmView..ExternalSyntheticLambda1(paramChatroomData, this), 200L);
      AppMethodBeat.o(276358);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/chatroom/view/JoinRoomExternalConfirmView$attachData$1$3$1$1", "Lcom/tencent/mm/plugin/game/utils/GameImageUtil$OnRemoteImageListener;", "onFinish", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "onStart", "s", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e.b
  {
    a(JoinRoomExternalConfirmView paramJoinRoomExternalConfirmView) {}
    
    private static final void a(JoinRoomExternalConfirmView paramJoinRoomExternalConfirmView, Bitmap paramBitmap)
    {
      AppMethodBeat.i(276507);
      kotlin.g.b.s.u(paramJoinRoomExternalConfirmView, "this$0");
      ((FixAspectRatioAndTopCropImageView)paramJoinRoomExternalConfirmView.findViewById(h.e.Ifu)).getLayoutParams().width = paramJoinRoomExternalConfirmView.getWidth();
      ((FixAspectRatioAndTopCropImageView)paramJoinRoomExternalConfirmView.findViewById(h.e.Ifu)).getLayoutParams().height = paramJoinRoomExternalConfirmView.getHeight();
      ((FixAspectRatioAndTopCropImageView)paramJoinRoomExternalConfirmView.findViewById(h.e.Ifu)).requestLayout();
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        ((FixAspectRatioAndTopCropImageView)paramJoinRoomExternalConfirmView.findViewById(h.e.Ifu)).setImageBitmap(paramBitmap);
      }
      AppMethodBeat.o(276507);
    }
    
    public final void a(View paramView, Bitmap paramBitmap)
    {
      AppMethodBeat.i(276516);
      if (paramBitmap == null)
      {
        AppMethodBeat.o(276516);
        return;
      }
      ((FixAspectRatioAndTopCropImageView)this.Isa.findViewById(h.e.Ifu)).post(new JoinRoomExternalConfirmView.a..ExternalSyntheticLambda0(this.Isa, paramBitmap));
      AppMethodBeat.o(276516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.JoinRoomExternalConfirmView
 * JD-Core Version:    0.7.0.1
 */