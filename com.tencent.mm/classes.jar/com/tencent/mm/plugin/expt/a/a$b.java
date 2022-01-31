package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$b
{
  static
  {
    AppMethodBeat.i(128624);
    lWn = new b("mmclient_expt_test", 0);
    lWo = new b("clicfg_open_mix_audio", 1);
    lWp = new b("clicfg_open_pre_draw", 2);
    lWq = new b("clicfg_ad_landing_page_new_stream_video", 3);
    lWr = new b("clicfg_appbrand_game_predownload", 4);
    lWs = new b("clicfg_appbrand_game_split_codelib", 5);
    lWt = new b("clicfg_keepaliveserviceswitch", 6);
    lWu = new b("clicfg_matrix_trace_fps_enable", 7);
    lWv = new b("clicfg_matrix_trace_care_scene_set", 8);
    lWw = new b("clicfg_matrix_trace_fps_time_slice", 9);
    lWx = new b("clicfg_matrix_trace_load_activity_threshold", 10);
    lWy = new b("clicfg_matrix_trace_evil_method_threshold", 11);
    lWz = new b("clicfg_matrix_trace_fps_report_threshold", 12);
    lWA = new b("clicfg_matrix_trace_max_evil_method_stack_num", 13);
    lWB = new b("clicfg_matrix_trace_max_evil_method_try_trim_num", 14);
    lWC = new b("clicfg_matrix_trace_min_evil_method_druration", 15);
    lWD = new b("clicfg_matrix_trace_time_upload_duration", 16);
    lWE = new b("clicfg_matrix_fps_dropped_normal", 17);
    lWF = new b("clicfg_matrix_fps_dropped_middle", 18);
    lWG = new b("clicfg_matrix_fps_dropped_high", 19);
    lWH = new b("clicfg_matrix_fps_dropped_frozen", 20);
    lWI = new b("clicfg_matrix_trace_evil_method_enable", 21);
    lWJ = new b("clicfg_matrix_trace_app_start_up_threshold", 22);
    lWK = new b("clicfg_matrix_trace_fps_frame_fresh_threshold", 23);
    lWL = new b("clicfg_matrix_trace_min_evil_method_run_cnt", 24);
    lWM = new b("clicfg_matrix_trace_min_evil_method_dur_time", 25);
    lWN = new b("clicfg_matrix_trace_splash_activity_name", 26);
    lWO = new b("clicfg_matrix_io_file_io_main_thread_enable", 27);
    lWP = new b("clicfg_matrix_io_main_thread_enable_threshold", 28);
    lWQ = new b("clicfg_matrix_io_small_buffer_enable", 29);
    lWR = new b("clicfg_matrix_io_small_buffer_threshold", 30);
    lWS = new b("clicfg_matrix_io_small_buffer_operator_times", 31);
    lWT = new b("clicfg_matrix_io_repeated_read_enable", 32);
    lWU = new b("clicfg_matrix_io_repeated_read_threshold", 33);
    lWV = new b("clicfg_matrix_io_closeable_leak_enable", 34);
    lWW = new b("clicfg_matrix_battery_detect_wake_lock_enable", 35);
    lWX = new b("clicfg_matrix_battery_record_wake_lock_enable", 36);
    lWY = new b("clicfg_matrix_battery_wake_lock_hold_time_threshold", 37);
    lWZ = new b("clicfg_matrix_battery_wake_lock_1h_acquire_cnt_threshold", 38);
    lXa = new b("clicfg_matrix_battery_wake_lock_1h_hold_time_threshold", 39);
    lXb = new b("clicfg_matrix_battery_detect_alarm_enable", 40);
    lXc = new b("clicfg_matrix_battery_record_alarm_enable", 41);
    lXd = new b("clicfg_matrix_battery_alarm_1h_trigger_cnt_threshold", 42);
    lXe = new b("clicfg_matrix_battery_wake_up_alarm_1h_trigger_cnt_threshold", 43);
    lXf = new b("clicfg_matrix_memory_middle_min_span", 44);
    lXg = new b("clicfg_matrix_memory_high_min_span", 45);
    lXh = new b("clicfg_matrix_memory_threshold", 46);
    lXi = new b("clicfg_matrix_memory_special_activities", 47);
    lXj = new b("clicfg_matrix_resource_detect_interval_millis", 48);
    lXk = new b("clicfg_matrix_resource_max_detect_times", 49);
    lXl = new b("clicfg_matrix_resource_dump_hprof_enable", 50);
    lXm = new b("clicfg_matrix_thread_check_time", 51);
    lXn = new b("clicfg_matrix_thread_report_time", 52);
    lXo = new b("clicfg_matrix_thread_contain_sys", 53);
    lXp = new b("clicfg_matrix_thread_filter_thread_set", 54);
    lXq = new b("clicfg_android_process_native", 55);
    lXr = new b("clicfg_android_process_vm", 56);
    lXs = new b("clicfg_android_process_java", 57);
    lXt = new b("clicfg_android_process_work_begin", 58);
    lXu = new b("clicfg_android_process_work_end", 59);
    lXv = new b("clicfg_android_process_enable", 60);
    lXw = new b("clicfg_android_process_is_hard_mode", 61);
    lXx = new b("clicfg_android_process_is_check_launcher_ui", 62);
    lXy = new b("clicfg_android_process_check_time", 63);
    lXz = new b("clicfg_android_process_jiffy_per_min", 64);
    lXA = new b("clicfg_android_process_traffic_per_min", 65);
    lXB = new b("clicfg_android_process_hard_info", 66);
    lXC = new b("clicfg_turnoff_tools_weapp", 67);
    lXD = new b("clicfg_appbrand_process_preload_memory_stress_time_limit", 68);
    lXE = new b("clicfg_appbrand_process_preload_frequence_limit", 69);
    lXF = new b("clicfg_tencent_map_download_page_direct", 70);
    lXG = new b("clicfg_j2v8_snapshot", 71);
    lXH = new b("clicfg_j2v8_codecache", 72);
    lXI = new b("clicfg_story_open", 73);
    lXJ = new b("clicfg_story_upgrades", 74);
    lXK = new b("clicfg_story_pre_click", 75);
    lXL = new b("clicfg_story_preload_strategy", 76);
    lXM = new b("clicfg_story_preload_speed_good", 77);
    lXN = new b("clicfg_story_preload_speed_bad", 78);
    lXO = new b("clicfg_story_preload_force_preload", 79);
    lXP = new b("clicfg_story_preload_force_canload", 80);
    lXQ = new b("clicfg_story_preload_with_enter_sns", 81);
    lXR = new b("clicfg_story_preload_with_enter_pop_sns", 82);
    lXS = new b("clicfg_story_preload_with_change_sns", 83);
    lXT = new b("clicfg_story_sns_story_open", 84);
    lXU = new b("clicfg_story_music_story_thumb_size", 85);
    lXV = new b("clicfg_media_iframe", 86);
    lXW = new b("clicfg_hellhound_switch", 87);
    lXX = new b("clicfg_hellhound_frontback_switch", 88);
    lXY = new b("clicfg_hellhound_session_switch", 89);
    lXZ = new b("clicfg_hellhound_timeline_switch", 90);
    lYa = new b("clicfg_webview_preview_img_with_ani", 91);
    lYb = new b("clicfg_webview_show_ssl_dialog", 92);
    lYc = new b("clicfg_webview_skip_user_cert", 93);
    lYd = new b("clicfg_webview_can_pre_inject_jsbridge", 94);
    lYe = new b("clicfg_webview_can_call_jsapi_before_loaded", 95);
    lYf = new b("clicfg_open_xweb_url_to_path", 96);
    lYg = new b("clicfg_android_xweb_code_cache", 97);
    lYh = new b("clicfg_weixin_mm_app_mgr", 98);
    lYi = new b("clicfg_weixin_mm_life_call", 99);
    lYj = new b("clicfg_weixin_mm_hell_hound", 100);
    lYk = new b("clicfg_weixin_rpt_mm_app_mgr", 101);
    lYl = new b("clicfg_weixin_rpt_mm_life_call", 102);
    lYm = new b("clicfg_weixin_rpt_mm_hell_hound", 103);
    lYn = new b("clicfg_weixin_register_mm_life_call", 104);
    lYo = new b("clicfg_weixin_register_mm_app_active_event", 105);
    lYp = new b("clicfg_waservice_webgl_component", 106);
    lYq = new b("clicfg_magicbrush_allow_antialias", 107);
    lYr = new b("clicfg_magicbrush_gcfactor", 108);
    lYs = new b("clicfg_magicbrush_autogcfactor_max_canvas", 109);
    lYt = new b("clicfg_magicbrush_autogcfactor_min_canvas", 110);
    lYu = new b("clicfg_magicbrush_autogcfactor_total_memory_ratio", 111);
    lYv = new b("clicfg_magicbrush_wxbct", 112);
    lYw = new b("clicfg_appbrand_socket_wcwss", 113);
    lYx = new b("clicfg_appbrand_game_socket_wcwss", 114);
    lYy = new b("clicfg_android_wxa_use_xweb_map", 115);
    lYz = new b("clicfg_android_weishi_video_preload", 116);
    lYA = new b("clicfg_android_weishi_video_preload_size", 117);
    lYB = new b("clicfg_android_xweb_video_exo", 118);
    lYC = new b("clicfg_android_wxa_use_xweb_canvas", 119);
    lYD = new b("clicfg_use_new_cached_imei_method", 120);
    lYE = new b("clicfg_android_appbrand_page_reload_eanble", 121);
    lYF = new b("clicfg_android_appbrand_choosevideo_new", 122);
    lYG = new b("clicfg_android_appbrand_fakenative_persistent", 123);
    lYH = new b("clicfg_android_appbrand_html_webview_outer_link_download", 124);
    lYI = new b("clicfg_appbrand_xweb_live", 125);
    lYJ = new b("clicfg_emoji_high_total_mem", 126);
    lYK = new b("clicfg_emoji_high_mem_class", 127);
    lYL = new b("clicfg_emoji_high_preview_size", 128);
    lYM = new b("clicfg_emoji_high_sample_size", 129);
    lYN = new b("clicfg_emoji_low_preview_size", 130);
    lYO = new b("clicfg_emoji_low_sample_size", 131);
    lYP = new b("clicfg_emoji_sdk_enablelog", 132);
    lYQ = new b("clicfg_emoji_segment_crash_auto_count", 133);
    lYR = new b("clicfg_emoji_segment_crash_manual_count", 134);
    lYS = new b("clicfg_nodejs_websocket_open", 135);
    lYT = new b("clicfg_nodejs_fs_open", 136);
    lYU = new b("clicfg_target26_start_service_switch", 137);
    lYV = new b("clicfg_target26_start_service_manufacturer", 138);
    lYW = new b("clicfg_if_show_ignore_battery_optimizations", 139);
    lYX = new b("clicfg_target26_start_service_manu_exclusive", 140);
    lYY = new b("clicfg_target26_start_service_switch_huawei", 141);
    lYZ = new b("clicfg_target26_start_service_huawei_info", 142);
    lZa = new b("clicfg_remuxer_with_surface_timestamp", 143);
    lZb = new b("clicfg_remuxer_check_b_frame", 144);
    lZc = new b("clicfg_sns_video_edit_remux_encoder_usex264", 145);
    lZd = new b("clicfg_c2c_video_edit_remux_encoder_usex264", 146);
    lZe = new b("clicfg_video_record_use_hardcode_encoder", 147);
    lZf = new b("clicfg_target26_voice_focus_shield_sw", 148);
    lZg = new b("clicfg_appbrand_game_splashscreen", 149);
    lZh = new b("clicfg_appbrand_game_commandbuffer", 150);
    lZi = new b("clicfg_nearby_app_preload_type", 151);
    lZj = new b("clicfg_android_appbrand_recommend_use_fake_native", 152);
    lZk = new b("clicfg_android_appbrand_search_by_image", 153);
    lZl = new b[] { lWn, lWo, lWp, lWq, lWr, lWs, lWt, lWu, lWv, lWw, lWx, lWy, lWz, lWA, lWB, lWC, lWD, lWE, lWF, lWG, lWH, lWI, lWJ, lWK, lWL, lWM, lWN, lWO, lWP, lWQ, lWR, lWS, lWT, lWU, lWV, lWW, lWX, lWY, lWZ, lXa, lXb, lXc, lXd, lXe, lXf, lXg, lXh, lXi, lXj, lXk, lXl, lXm, lXn, lXo, lXp, lXq, lXr, lXs, lXt, lXu, lXv, lXw, lXx, lXy, lXz, lXA, lXB, lXC, lXD, lXE, lXF, lXG, lXH, lXI, lXJ, lXK, lXL, lXM, lXN, lXO, lXP, lXQ, lXR, lXS, lXT, lXU, lXV, lXW, lXX, lXY, lXZ, lYa, lYb, lYc, lYd, lYe, lYf, lYg, lYh, lYi, lYj, lYk, lYl, lYm, lYn, lYo, lYp, lYq, lYr, lYs, lYt, lYu, lYv, lYw, lYx, lYy, lYz, lYA, lYB, lYC, lYD, lYE, lYF, lYG, lYH, lYI, lYJ, lYK, lYL, lYM, lYN, lYO, lYP, lYQ, lYR, lYS, lYT, lYU, lYV, lYW, lYX, lYY, lYZ, lZa, lZb, lZc, lZd, lZe, lZf, lZg, lZh, lZi, lZj, lZk };
    AppMethodBeat.o(128624);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.a.b
 * JD-Core Version:    0.7.0.1
 */