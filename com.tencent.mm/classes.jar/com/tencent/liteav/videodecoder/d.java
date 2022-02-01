package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class d
{
  private boolean a = false;
  private boolean b = false;
  
  private void a(c paramc)
  {
    AppMethodBeat.i(230419);
    int j = paramc.a("SPS: cpb_cnt_minus1");
    paramc.b(4, "HRD: bit_rate_scale");
    paramc.b(4, "HRD: cpb_size_scale");
    int i = 0;
    while (i <= j)
    {
      paramc.b("HRD: bit_rate_value_minus1");
      paramc.b("HRD: cpb_size_value_minus1");
      paramc.b(1, "HRD: cbr_flag");
      i += 1;
    }
    paramc.b(5, "HRD: initial_cpb_removal_delay_length_minus1");
    paramc.b(5, "HRD: cpb_removal_delay_length_minus1");
    paramc.b(5, "HRD: dpb_output_delay_length_minus1");
    paramc.b(5, "HRD: time_offset_length");
    AppMethodBeat.o(230419);
  }
  
  private boolean b(c paramc)
  {
    AppMethodBeat.i(230423);
    if ((paramc.d("VUI: aspect_ratio_info_present_flag")) && ((int)paramc.a(8, "VUI: aspect_ratio") == 255))
    {
      paramc.b(16, "VUI: sar_width");
      paramc.b(16, "VUI: sar_height");
    }
    if (paramc.d("VUI: overscan_info_present_flag")) {
      paramc.b(1, "VUI: overscan_appropriate_flag");
    }
    if (paramc.d("VUI: video_signal_type_present_flag"))
    {
      paramc.b(3, "VUI: video_format");
      paramc.b(1, "VUI: video_full_range_flag");
      if (paramc.d("VUI: colour_description_present_flag"))
      {
        paramc.b(8, "VUI: colour_primaries");
        paramc.b(8, "VUI: transfer_characteristics");
        paramc.b(8, "VUI: matrix_coefficients");
      }
    }
    if (paramc.d("VUI: chroma_loc_info_present_flag"))
    {
      paramc.b("VUI chroma_sample_loc_type_top_field");
      paramc.b("VUI chroma_sample_loc_type_bottom_field");
    }
    if (paramc.d("VUI: timing_info_present_flag"))
    {
      paramc.b(32, "VUI: num_units_in_tick");
      paramc.b(32, "VUI: time_scale");
      paramc.b(1, "VUI: fixed_frame_rate_flag");
    }
    boolean bool1 = paramc.d("VUI: nal_hrd_parameters_present_flag");
    if (bool1) {
      a(paramc);
    }
    boolean bool2 = paramc.d("VUI: vcl_hrd_parameters_present_flag");
    if (bool2) {
      a(paramc);
    }
    if ((bool1) || (bool2)) {
      paramc.b(1, "VUI: low_delay_hrd_flag");
    }
    paramc.b(1, "VUI: pic_struct_present_flag");
    if (paramc.e("VUI: bitstream_restriction_flag"))
    {
      paramc.a(true, "VUI: set bitstream_restriction_flag");
      paramc.d("VUI: motion_vectors_over_pic_boundaries_flag");
      paramc.b("VUI max_bytes_per_pic_denom");
      paramc.b("VUI max_bits_per_mb_denom");
      paramc.b("VUI log2_max_mv_length_horizontal");
      paramc.b("VUI log2_max_mv_length_vertical");
      paramc.b("VUI num_reorder_frames");
      if (!this.b)
      {
        TXCLog.w("[H264SPSModifier]", "decode: do not add max_dec_frame_buffering when it is ".concat(String.valueOf(paramc.c(false))));
        this.b = true;
      }
      AppMethodBeat.o(230423);
      return false;
    }
    paramc.a(true, "VUI: set bitstream_restriction_flag");
    paramc.a(true, "VUI: motion_vectors_over_pic_boundaries_flag");
    paramc.c(0, "VUI: max_bytes_per_pic_denom");
    paramc.c(0, "VUI: max_bits_per_mb_denom");
    paramc.c(10, "VUI: log2_max_mv_length_horizontal");
    paramc.c(10, "VUI: log2_max_mv_length_vertical");
    paramc.c(0, "VUI: num_reorder_frames");
    paramc.c(1, "VUI: max_dec_frame_buffering");
    if (!this.b)
    {
      TXCLog.w("[H264SPSModifier]", "decode: add max_dec_frame_buffering 1 when it is no exist");
      this.b = true;
    }
    AppMethodBeat.o(230423);
    return true;
  }
  
  public byte[] a(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(230416);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new c(paramInputStream, (OutputStream)localObject);
    paramInputStream.b(8, "NALU type");
    int i = (int)paramInputStream.a(8, "SPS: profile_idc");
    paramInputStream.b(8, "SPS: constraint_set_0-3_flag and reserved_zero_4bits");
    paramInputStream.a(8, "SPS: level_idc");
    paramInputStream.b("SPS: seq_parameter_set_id");
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.a("SPS: chroma_format_idc") == 3) {
        paramInputStream.b(1, "SPS: residual_color_transform_flag");
      }
      paramInputStream.b("SPS: bit_depth_luma_minus8");
      paramInputStream.b("SPS: bit_depth_chroma_minus8");
      paramInputStream.b(1, "SPS: qpprime_y_zero_transform_bypass_flag");
      if (paramInputStream.d("SPS: seq_scaling_matrix_present_lag"))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.d("SPS: seqScalingListPresentFlag"))
          {
            if (i >= 6) {
              break label174;
            }
            paramInputStream.c(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label174:
            paramInputStream.c(64);
          }
        }
      }
    }
    paramInputStream.b("SPS: log2_max_frame_num_minus4");
    i = paramInputStream.a("SPS: pic_order_cnt_type");
    if (i == 0) {
      paramInputStream.b("SPS: log2_max_pic_order_cnt_lsb_minus4");
    }
    for (;;)
    {
      paramInputStream.a("SPS: num_ref_frames");
      paramInputStream.b(1, "SPS: gaps_in_frame_num_value_allowed_flag");
      paramInputStream.b("SPS: pic_width_in_mbs_minus1");
      paramInputStream.b("SPS: pic_height_in_map_units_minus1");
      if (!paramInputStream.d("SPS: frame_mbs_only_flag")) {
        paramInputStream.b(1, "SPS: mb_adaptive_frame_field_flag");
      }
      paramInputStream.b(1, "SPS: direct_8x8_inference_flag");
      if (paramInputStream.d("SPS: frame_cropping_flag"))
      {
        paramInputStream.b("SPS: frame_crop_left_offset");
        paramInputStream.b("SPS: frame_crop_right_offset");
        paramInputStream.b("SPS: frame_crop_top_offset");
        paramInputStream.b("SPS: frame_crop_bottom_offset");
      }
      if (!paramInputStream.e("SPS: vui_parameters_present_flag")) {
        break;
      }
      paramInputStream.a(true, "VUI set 1: ");
      if (b(paramInputStream)) {
        break label535;
      }
      AppMethodBeat.o(230416);
      return null;
      if (i == 1)
      {
        paramInputStream.b(1, "SPS: delta_pic_order_always_zero_flag");
        paramInputStream.b("SPS: offset_for_non_ref_pic");
        paramInputStream.b("SPS: offset_for_top_to_bottom_field");
        int k = paramInputStream.a("SPS: num_ref_frames_in_pic_order_cnt_cycle");
        i = 0;
        while (i < k)
        {
          paramInputStream.b("SPS: offsetForRefFrame [" + i + "]");
          i += 1;
        }
      }
    }
    paramInputStream.a(true, "VUI set 1: ");
    paramInputStream.a(false, "VUI: aspect_ratio_info_present_flag");
    paramInputStream.a(false, "VUI: overscan_info_present_flag");
    paramInputStream.a(false, "VUI: video_signal_type_present_flag");
    paramInputStream.a(false, "VUI: chroma_loc_info_present_flag");
    paramInputStream.a(false, "VUI: timing_info_present_flag");
    paramInputStream.a(false, "VUI: nal_hrd_parameters_present_flag");
    paramInputStream.a(false, "VUI: vcl_hrd_parameters_present_flag");
    paramInputStream.a(false, "VUI: pic_struct_present_flag");
    paramInputStream.a(true, "VUI: bitstream_restriction_flag");
    paramInputStream.a(true, "VUI: motion_vectors_over_pic_boundaries_flag");
    paramInputStream.c(0, "VUI: max_bytes_per_pic_denom");
    paramInputStream.c(0, "VUI: max_bits_per_mb_denom");
    paramInputStream.c(10, "VUI: log2_max_mv_length_horizontal");
    paramInputStream.c(10, "VUI: log2_max_mv_length_vertical");
    paramInputStream.c(0, "VUI: num_reorder_frames");
    paramInputStream.c(1, "VUI: max_dec_frame_buffering");
    if (!this.b)
    {
      TXCLog.w("[H264SPSModifier]", "decode: add max_dec_frame_buffering 1 when vui is no exist");
      this.b = true;
    }
    label535:
    paramInputStream.c();
    byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
    if (this.a)
    {
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = "0".concat(String.valueOf(str));
        }
        paramInputStream = paramInputStream + " " + (String)localObject;
        i += 1;
      }
    }
    AppMethodBeat.o(230416);
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230413);
    if (this.a)
    {
      String str1 = "";
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        String str2 = str3;
        if (str3.length() == 1) {
          str2 = "0".concat(String.valueOf(str3));
        }
        str1 = str1 + " " + str2;
        i += 1;
      }
    }
    paramArrayOfByte = a(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(230413);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.d
 * JD-Core Version:    0.7.0.1
 */