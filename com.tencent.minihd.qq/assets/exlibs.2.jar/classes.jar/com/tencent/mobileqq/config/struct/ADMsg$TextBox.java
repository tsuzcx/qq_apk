package com.tencent.mobileqq.config.struct;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.config.Command;
import com.tencent.mobileqq.config.ConfigDialog;
import com.tencent.qphone.base.util.BaseApplication;

public class ADMsg$TextBox
  extends ConfigDialog
{
  public ADMsg$TextBox(ADMsg paramADMsg, Context paramContext)
  {
    super(paramContext);
  }
  
  public ADMsg$TextBox(ADMsg paramADMsg, String paramString1, String paramString2, int paramInt)
  {
    super(BaseApplication.getContext());
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(Command paramCommand) {}
  
  public void a(ADMsg paramADMsg) {}
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.ADMsg.TextBox
 * JD-Core Version:    0.7.0.1
 */