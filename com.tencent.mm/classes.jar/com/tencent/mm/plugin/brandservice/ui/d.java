package com.tencent.mm.plugin.brandservice.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/BizTimeLineAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MMBaseAccessibilityConfig
{
  public static final d.a vDn;
  
  static
  {
    AppMethodBeat.i(301709);
    vDn = new d.a((byte)0);
    AppMethodBeat.o(301709);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(301707);
    AppMethodBeat.o(301707);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(301716);
    root(d.f.biz_time_line_hot_view).view(d.e.biz_time_line_hot_view_title).desc(d.e.biz_time_line_hot_view_title);
    root(d.e.biz_time_line_hot_view_item_id).view(d.e.biz_time_line_hot_view_item_id).descFormat(d.i.talkback_placehodler_2).valueByView(d.e.biz_time_line_hot_view_item_title).valueByView(d.e.biz_time_line_hot_view_item_live_title).disableChildren();
    root(d.f.biz_time_line_new_msg_line_layout).view(d.e.biz_time_line_new_msg_line_layout_id).disable();
    root(d.f.biz_time_line_item).view(d.e.avatar_iv).disable();
    root(d.e.biz_time_line_item_top_slot).view(d.e.topSlot_click_view).desc((b)new d.c(this)).disableChildren();
    root(d.e.biz_time_line_comm_slot).view(d.e.biz_time_line_comm_slot).desc((b)new d.d(this)).disableChildren();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(d.e.chatting_item_biz_text_click_view);
    localConfigHelper.view(d.e.chatting_item_biz_text_click_view).descFormat(d.i.talkback_placehodler_2).valueByView(d.e.biz_time_line_text).valueByView(d.e.friends_read_tv);
    localConfigHelper.view(d.e.biz_time_line_text).disable();
    root(d.e.biz_time_line_item_video_slot).view(d.e.chatting_item_biz_video_click_view).descFormat(d.i.biz_timeline_placeholder_video).valueByView(d.e.play_time_tv).valueByView(d.e.title_tv).valueByView(d.e.friends_read_tv).valueByView(d.e.single_title_tv).valueByView(d.e.friends_read_tv_bottom).valueByView(d.e.single_digest_tv).disableChildren();
    localConfigHelper = root(d.e.biz_time_line_item_voice_slot);
    localConfigHelper.view(d.e.chatting_item_biz_voice_click_view).descFormat(d.i.biz_timeline_placeholder_radio).valueByView(d.e.title_tv).valueByView(d.e.play_time_tv).valueByView(d.e.friends_read_tv).valueByView(d.e.biz_time_line_item_voice_digest);
    localConfigHelper.view(d.e.title_tv).disable();
    localConfigHelper.view(d.e.big_play_icon).desc(d.i.biz_timeline_radio_play_icon).disableChildren();
    localConfigHelper = root(d.e.rec_feed_tag_layout);
    localConfigHelper.view(d.e.rec_feed_tag_layout).descFormat(d.i.talkback_placehodler_4).valueByView(d.e.jump_link).valueByView(d.e.rec_feed_tag).valueByView(d.e.rec_feed_tag_rec_reason_tv).valueByView(d.e.rec_feed_tag_rec_read_more);
    localConfigHelper.disable(d.e.jump_link);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.rec_feed_tag_rec_reason_tv);
    localConfigHelper.disable(d.e.rec_feed_tag_rec_read_more);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_pic);
    localConfigHelper.view(d.e.chatting_item_rec_feed_click_view).descFormat(d.i.talkback_placehodler_3).valueByView(d.e.rec_pic_icon_and_num).valueByView(d.e.rec_feed_tag).valueByView(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.rec_pic_icon_and_num);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_text);
    localConfigHelper.view(d.e.chatting_item_rec_feed_click_view).descFormat(d.i.talkback_placehodler_3).valueByView(d.e.chatting_item_rec_feed_title_tv).valueByView(d.e.rec_feed_tag).valueByView(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_title_tv);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    root(d.f.biz_time_line_rec_feed_common_tag_slot).view(d.e.content_ll).descFormat(d.i.talkback_placehodler).valueByView(d.e.title_neat_tv).disableChildren().type(ViewType.Button);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_article);
    localConfigHelper.view(d.e.chatting_item_rec_feed_click_view).descFormat(d.i.talkback_placehodler_4).valueByView(d.e.chatting_item_rec_feed_title_tv).valueByView(d.e.chatting_item_rec_feed_content_tv).valueByView(d.e.rec_feed_tag).valueByView(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_title_tv);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_content_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.view(d.e.close_layout).desc(d.i.biz_timeline_rec_close_btn);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_video);
    localConfigHelper.view(d.e.chatting_item_rec_feed_click_view).desc((b)new d.b(this));
    localConfigHelper.disable(d.e.chatting_item_rec_feed_title_tv);
    localConfigHelper.disable(d.e.play_time_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.view(d.e.close_layout).desc(d.i.biz_timeline_rec_close_btn);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_common_slot);
    localConfigHelper.view(d.e.biz_time_line_feed_common_slot_id).descFormat(d.i.talkback_placehodler_5).valueByView(d.e.top_title_tv).valueByView(d.e.title_neat_tv).valueByView(d.e.artitle_content_tv).valueByView(d.e.rec_feed_tag).valueByView(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.disable(d.e.top_title_tv);
    localConfigHelper.disable(d.e.title_neat_tv);
    localConfigHelper.disable(d.e.artitle_content_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.view(d.e.close_layout).desc(d.i.biz_timeline_rec_close_btn);
    localConfigHelper = root(d.f.biz_time_line_rec_feed_multi_pic_article);
    localConfigHelper.view(d.e.chatting_item_rec_feed_click_view).descFormat(d.i.talkback_placehodler_4).valueByView(d.e.chatting_item_rec_feed_title_tv).valueByView(d.e.artitle_content_tv).valueByView(d.e.rec_feed_tag).valueByView(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_title_tv);
    localConfigHelper.disable(d.e.artitle_content_tv);
    localConfigHelper.disable(d.e.rec_feed_tag);
    localConfigHelper.disable(d.e.chatting_item_rec_feed_digest_tv);
    localConfigHelper.view(d.e.close_layout).desc(d.i.biz_timeline_rec_close_btn);
    root(d.f.biz_time_line_rec_card_multiaccount).view(d.e.close_layout).desc(d.i.biz_timeline_rec_close_btn);
    root(d.e.biz_time_line_item_video_slot_for_rec).view(d.e.chatting_item_biz_video_click_view).descFormat(d.i.biz_timeline_placeholder_video_4).valueByView(d.e.play_time_tv).valueByView(d.e.title_tv).valueByView(d.e.single_title_tv).valueByView(d.e.single_digest_tv).disableChildren();
    root(d.e.biz_time_line_item_top_slot_for_rec).view(d.e.topSlot_click_view).descFormat(d.i.talkback_placehodler_3).valueByView(d.e.title_tv).valueByView(d.e.single_title_tv).valueByView(d.e.single_digest_tv).disableChildren();
    localConfigHelper = root(d.f.biz_tl_rec_card_old);
    localConfigHelper.view(d.e.biz_rec_card_profile_layout).descFormat(d.i.talkback_placehodler_3).valueByView(d.e.nick_name_tv).valueByView(d.e.biz_rec_card_reason_tv).valueByView(d.e.biz_rec_card_desc_tv).disableChildren();
    localConfigHelper.view(d.e.biz_rec_card_appmsg_layout).descFormat(d.i.talkback_placehodler_2).valueByView(d.e.biz_rec_card_appmsg_reason_tv).valueByView(d.e.biz_rec_card_appmsg_title_tv).disableChildren();
    root(d.f.biz_time_line_rec_card_subscribe).view(d.e.biz_time_line_rec_card_subscribe_header).descFormat(d.i.talkback_placehodler_2).valueByView(d.e.jump_link).valueByView(d.e.time).type(ViewType.Button).disableChildren();
    root(d.f.biz_time_line_rec_card_common_slot).view(d.e.content_ll).descFormat(d.i.talkback_placehodler_3).valueByView(d.e.title_neat_tv).valueByView(d.e.summary).valueByView(d.e.friends_read_tv).type(ViewType.Button).disableChildren();
    root(d.f.biz_time_line_rec_card_common_slotv2).view(d.e.content_ll).descFormat(d.i.talkback_placehodler_2).valueByView(d.e.title_neat_tv).valueByView(d.e.summary).disableChildren().type(ViewType.Button);
    AppMethodBeat.o(301716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.d
 * JD-Core Version:    0.7.0.1
 */