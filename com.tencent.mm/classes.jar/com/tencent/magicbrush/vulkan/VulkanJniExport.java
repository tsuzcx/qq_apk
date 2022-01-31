package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.a.c;

public class VulkanJniExport
{
  static
  {
    c.loadLibrary("mmvulkan");
  }
  
  public static native boolean isSupportVulkan();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.vulkan.VulkanJniExport
 * JD-Core Version:    0.7.0.1
 */