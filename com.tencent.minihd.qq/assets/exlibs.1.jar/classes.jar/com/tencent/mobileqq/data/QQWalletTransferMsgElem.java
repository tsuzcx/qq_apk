package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioElem;

public class QQWalletTransferMsgElem
{
  public String actionsPriority;
  public int background;
  public String baseMap;
  public String blackStripe;
  public String content;
  public int icon;
  public String jumpUrl;
  public String linkUrl;
  public String nativeAndroid;
  public String notice;
  public String subTitle;
  public int subtitleColor;
  public String title;
  public int titleColor;
  
  public QQWalletTransferMsgElem() {}
  
  public QQWalletTransferMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    if (paramQQWalletAioElem == null) {
      return;
    }
    this.background = paramQQWalletAioElem.uint32_background.get();
    this.icon = paramQQWalletAioElem.uint32_icon.get();
    this.title = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
    this.subTitle = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
    this.content = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
    this.linkUrl = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
    this.blackStripe = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
    this.notice = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
    if (this.linkUrl == null) {
      this.linkUrl = "";
    }
    if (this.blackStripe == null) {
      this.blackStripe = "";
    }
    if (this.notice == null) {
      this.notice = "";
    }
    this.background |= 0xFF000000;
    if (paramQQWalletAioElem.uint32_title_color.has())
    {
      this.titleColor = paramQQWalletAioElem.uint32_title_color.get();
      this.titleColor |= 0xFF000000;
      if (!paramQQWalletAioElem.uint32_subtitle_color.has()) {
        break label316;
      }
      this.subtitleColor = paramQQWalletAioElem.uint32_subtitle_color.get();
      this.subtitleColor |= 0xFF000000;
      label229:
      if (!paramQQWalletAioElem.bytes_actions_priority.has()) {
        break label324;
      }
      this.actionsPriority = paramQQWalletAioElem.bytes_actions_priority.get().toStringUtf8();
      label253:
      if (!paramQQWalletAioElem.bytes_jump_url.has()) {
        break label333;
      }
      this.jumpUrl = paramQQWalletAioElem.bytes_jump_url.get().toStringUtf8();
      label277:
      if (!paramQQWalletAioElem.bytes_native_android.has()) {
        break label342;
      }
    }
    label316:
    label324:
    label333:
    label342:
    for (this.nativeAndroid = paramQQWalletAioElem.bytes_native_android.get().toStringUtf8();; this.nativeAndroid = "")
    {
      this.baseMap = "";
      return;
      this.titleColor = -1;
      break;
      this.subtitleColor = -1;
      break label229;
      this.actionsPriority = "";
      break label253;
      this.jumpUrl = "";
      break label277;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsgElem
 * JD-Core Version:    0.7.0.1
 */