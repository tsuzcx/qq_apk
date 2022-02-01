package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import iww;
import iwx;
import iwy;
import iwz;
import ixa;
import ixb;
import ixc;
import ixd;
import ixe;
import ixi;

public class ActionBarUtil
{
  public static View.OnClickListener a(Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixb(paramActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixd(paramBaseActivity, paramFileManagerEntity, paramDataLineHandler, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(DataLineHandler paramDataLineHandler, BaseActivity paramBaseActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixc(paramDataLineHandler, paramBaseActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new iwy(paramFileManagerEntity, paramQQAppInterface, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, IFileBrowser paramIFileBrowser, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new iww(paramIFileBrowser, paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixa(paramQQAppInterface, paramString, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixi(paramQQAppInterface, paramFileManagerEntity, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new iwz(paramFileManagerEntity, paramQQAppInterface, paramInt, paramActivity, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener a(boolean paramBoolean, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new ixe(paramBoolean, paramQQAppInterface, paramActivity, paramString, paramIActionBarClickEvent);
  }
  
  public static View.OnClickListener b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    return new iwx(paramString, paramActivity, paramQQAppInterface, paramIActionBarClickEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil
 * JD-Core Version:    0.7.0.1
 */