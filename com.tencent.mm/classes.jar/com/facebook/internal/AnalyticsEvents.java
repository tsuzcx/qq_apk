package com.facebook.internal;

public class AnalyticsEvents
{
  public static final String EVENT_DEVICE_SHARE_BUTTON_CREATE = "fb_device_share_button_create";
  public static final String EVENT_DEVICE_SHARE_BUTTON_DID_TAP = "fb_device_share_button_did_tap";
  public static final String EVENT_FRIEND_PICKER_USAGE = "fb_friend_picker_usage";
  public static final String EVENT_LIKE_BUTTON_CREATE = "fb_like_button_create";
  public static final String EVENT_LIKE_BUTTON_DID_TAP = "fb_like_button_did_tap";
  public static final String EVENT_LIKE_VIEW_CANNOT_PRESENT_DIALOG = "fb_like_control_cannot_present_dialog";
  public static final String EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED = "fb_like_control_dialog_did_succeed";
  public static final String EVENT_LIKE_VIEW_DID_LIKE = "fb_like_control_did_like";
  public static final String EVENT_LIKE_VIEW_DID_PRESENT_DIALOG = "fb_like_control_did_present_dialog";
  public static final String EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK = "fb_like_control_did_present_fallback_dialog";
  public static final String EVENT_LIKE_VIEW_DID_UNDO_QUICKLY = "fb_like_control_did_undo_quickly";
  public static final String EVENT_LIKE_VIEW_DID_UNLIKE = "fb_like_control_did_unlike";
  public static final String EVENT_LIKE_VIEW_ERROR = "fb_like_control_error";
  public static final String EVENT_LOGIN_BUTTON_CREATE = "fb_login_button_create";
  public static final String EVENT_LOGIN_BUTTON_DID_TAP = "fb_login_button_did_tap";
  public static final String EVENT_LOGIN_VIEW_USAGE = "fb_login_view_usage";
  public static final String EVENT_NATIVE_DIALOG_COMPLETE = "fb_native_dialog_complete";
  public static final String EVENT_NATIVE_DIALOG_START = "fb_native_dialog_start";
  public static final String EVENT_NATIVE_DIALOG_TYPE_LIKE = "fb_dialogs_present_like";
  public static final String EVENT_NATIVE_DIALOG_TYPE_MESSAGE = "fb_dialogs_present_message";
  public static final String EVENT_NATIVE_DIALOG_TYPE_OG_MESSAGE = "fb_dialogs_present_message_og";
  public static final String EVENT_NATIVE_DIALOG_TYPE_OG_SHARE = "fb_dialogs_present_share_og";
  public static final String EVENT_NATIVE_DIALOG_TYPE_PHOTO_MESSAGE = "fb_dialogs_present_message_photo";
  public static final String EVENT_NATIVE_DIALOG_TYPE_PHOTO_SHARE = "fb_dialogs_present_share_photo";
  public static final String EVENT_NATIVE_DIALOG_TYPE_SHARE = "fb_dialogs_present_share";
  public static final String EVENT_NATIVE_DIALOG_TYPE_VIDEO_SHARE = "fb_dialogs_present_share_video";
  public static final String EVENT_NATIVE_LOGIN_DIALOG_COMPLETE = "fb_dialogs_native_login_dialog_complete";
  public static final String EVENT_NATIVE_LOGIN_DIALOG_START = "fb_dialogs_native_login_dialog_start";
  public static final String EVENT_PLACE_PICKER_USAGE = "fb_place_picker_usage";
  public static final String EVENT_SDK_INITIALIZE = "fb_sdk_initialize";
  public static final String EVENT_SEND_BUTTON_CREATE = "fb_send_button_create";
  public static final String EVENT_SEND_BUTTON_DID_TAP = "fb_send_button_did_tap";
  public static final String EVENT_SHARE_BUTTON_CREATE = "fb_share_button_create";
  public static final String EVENT_SHARE_BUTTON_DID_TAP = "fb_share_button_did_tap";
  public static final String EVENT_SHARE_DIALOG_SHOW = "fb_share_dialog_show";
  public static final String EVENT_SHARE_MESSENGER_DIALOG_SHOW = "fb_messenger_share_dialog_show";
  public static final String EVENT_SHARE_RESULT = "fb_share_dialog_result";
  public static final String EVENT_SMART_LOGIN_SERVICE = "fb_smart_login_service";
  public static final String EVENT_USER_SETTINGS_USAGE = "fb_user_settings_vc_usage";
  public static final String EVENT_WEB_LOGIN_COMPLETE = "fb_dialogs_web_login_dialog_complete";
  public static final String PARAMETER_ACTION_ID = "action_id";
  public static final String PARAMETER_APP_ID = "app_id";
  public static final String PARAMETER_CALL_ID = "call_id";
  public static final String PARAMETER_DIALOG_OUTCOME = "fb_dialog_outcome";
  public static final String PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED = "Cancelled";
  public static final String PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED = "Completed";
  public static final String PARAMETER_DIALOG_OUTCOME_VALUE_FAILED = "Failed";
  public static final String PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN = "Unknown";
  public static final String PARAMETER_LIKE_VIEW_AUXILIARY_POSITION = "auxiliary_position";
  public static final String PARAMETER_LIKE_VIEW_CURRENT_ACTION = "current_action";
  public static final String PARAMETER_LIKE_VIEW_ERROR_JSON = "error";
  public static final String PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT = "horizontal_alignment";
  public static final String PARAMETER_LIKE_VIEW_OBJECT_ID = "object_id";
  public static final String PARAMETER_LIKE_VIEW_OBJECT_TYPE = "object_type";
  public static final String PARAMETER_LIKE_VIEW_STYLE = "style";
  public static final String PARAMETER_NATIVE_LOGIN_DIALOG_COMPLETE_TIME = "fb_native_login_dialog_complete_time";
  public static final String PARAMETER_NATIVE_LOGIN_DIALOG_START_TIME = "fb_native_login_dialog_start_time";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_OPENGRAPH = "open_graph";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_PAGE_ID = "fb_share_dialog_content_page_id";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_PHOTO = "photo";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_STATUS = "status";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_TYPE = "fb_share_dialog_content_type";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_UNKNOWN = "unknown";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_UUID = "fb_share_dialog_content_uuid";
  public static final String PARAMETER_SHARE_DIALOG_CONTENT_VIDEO = "video";
  public static final String PARAMETER_SHARE_DIALOG_SHOW = "fb_share_dialog_show";
  public static final String PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC = "automatic";
  public static final String PARAMETER_SHARE_DIALOG_SHOW_NATIVE = "native";
  public static final String PARAMETER_SHARE_DIALOG_SHOW_UNKNOWN = "unknown";
  public static final String PARAMETER_SHARE_DIALOG_SHOW_WEB = "web";
  public static final String PARAMETER_SHARE_ERROR_MESSAGE = "error_message";
  public static final String PARAMETER_SHARE_MESSENGER_GENERIC_TEMPLATE = "GenericTemplate";
  public static final String PARAMETER_SHARE_MESSENGER_MEDIA_TEMPLATE = "MediaTemplate";
  public static final String PARAMETER_SHARE_MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE = "OpenGraphMusicTemplate";
  public static final String PARAMETER_SHARE_OUTCOME = "fb_share_dialog_outcome";
  public static final String PARAMETER_SHARE_OUTCOME_CANCELLED = "cancelled";
  public static final String PARAMETER_SHARE_OUTCOME_ERROR = "error";
  public static final String PARAMETER_SHARE_OUTCOME_SUCCEEDED = "succeeded";
  public static final String PARAMETER_SHARE_OUTCOME_UNKNOWN = "unknown";
  public static final String PARAMETER_WEB_LOGIN_E2E = "fb_web_login_e2e";
  public static final String PARAMETER_WEB_LOGIN_SWITCHBACK_TIME = "fb_web_login_switchback_time";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.AnalyticsEvents
 * JD-Core Version:    0.7.0.1
 */