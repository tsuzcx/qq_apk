package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class mobileqq_dynamic_search$PluginState
  extends MessageMicro
{
  public static final int PLUGIN_ID_FIELD_NUMBER = 1;
  public static final int PLUGIN_SWITCH_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "plugin_id", "plugin_switch" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PluginState.class);
  public final PBInt32Field plugin_id = PBField.initInt32(0);
  public final PBInt32Field plugin_switch = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.PluginState
 * JD-Core Version:    0.7.0.1
 */