package com.tencent.magicbrush;

import android.content.res.AssetManager;
import androidx.annotation.Keep;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.ui.a.b;

@Keep
public class MBRuntime$MBParams
{
  public boolean adjust_thread_priority = true;
  public boolean allow_antialias_ = false;
  public boolean allow_opengl3 = true;
  public a.b animationFrameHandlerStrategy = a.b.cPn;
  public long app_brand_runtime = 0L;
  AssetManager asset_manager;
  public int cmd_pool_type = 1;
  public float device_pixel_ratio_ = -1.0F;
  public boolean enable_2d = true;
  public boolean enable_font_batch = false;
  public boolean enable_gfx = true;
  public boolean enable_request_animation_frame = true;
  public boolean enable_window_attributes_alpha = false;
  public boolean enable_wxbindcanvastexture = false;
  public IMBFileSystem file_system_ = null;
  public boolean force_run_v8_microtasks = false;
  public float gc_factor = 0.0F;
  public boolean is_game = false;
  public boolean perf_crazy_mode = false;
  public String render_thread_name;
  public boolean render_thread_profiler = false;
  public boolean revert_cpu_optimizer_test = false;
  public int screen_height_ = -1;
  public int screen_width_ = -1;
  public String sdcard_path;
  public boolean support_client_vertex_buffer = false;
  public boolean support_etc2_astc = false;
  public int support_gfximage_share_texture = 1;
  public boolean support_hardware_decode = true;
  public boolean support_hardware_encode = true;
  public boolean sync_surface_destroy = true;
  public boolean use_command_buffer = true;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.MBParams
 * JD-Core Version:    0.7.0.1
 */