package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import jaa;
import java.util.List;

public class TroopPhotoFileView
  extends PhotoFileViewBase
{
  public jaa a;
  public String a;
  public String b;
  
  public TroopPhotoFileView(Activity paramActivity, QQAppInterface paramQQAppInterface, List paramList, int paramInt)
  {
    super(paramActivity, paramList, paramInt);
    this.jdField_a_of_type_JavaLangString = "TroopPhotoFileView";
    this.jdField_a_of_type_Jaa = new jaa(this, paramQQAppInterface);
    this.jdField_a_of_type_Jaa.a();
  }
  
  protected PhotoFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_Jaa;
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView
 * JD-Core Version:    0.7.0.1
 */