package com.tencent.mobileqq.activity.aio.photo;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class AIOPhotoListUtils
{
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListUtils
 * JD-Core Version:    0.7.0.1
 */