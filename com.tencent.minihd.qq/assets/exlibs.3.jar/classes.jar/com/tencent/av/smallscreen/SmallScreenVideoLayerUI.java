package com.tencent.av.smallscreen;

import android.content.Context;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.qav.ui.C2CVideoView;

public class SmallScreenVideoLayerUI
  extends GLViewGroup
{
  private Context jdField_a_of_type_AndroidContentContext;
  private C2CVideoView jdField_a_of_type_ComTencentQavUiC2CVideoView;
  private C2CVideoView b;
  
  public SmallScreenVideoLayerUI(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView = new C2CVideoView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(1);
    addView(this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
    this.b = new C2CVideoView(this.jdField_a_of_type_AndroidContentContext);
    this.b.setVisibility(1);
    addView(this.b);
    b();
  }
  
  private void a(GLVideoView paramGLVideoView)
  {
    paramGLVideoView.layout(0, 0, getWidth(), getHeight());
    paramGLVideoView.setPaddings(0, 0, 0, 0);
    paramGLVideoView.setBackgroundColor(-15197410);
    paramGLVideoView.setZOrder(0);
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_ComTencentQavUiC2CVideoView);
    a(this.b);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setSelfUin(paramString1);
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setInfo(paramString1, 1);
    this.b.setSelfUin(paramString1);
    this.b.setInfo(paramString2, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setNeedRenderVideo(paramBoolean);
    if (paramBoolean)
    {
      this.b.a();
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setNeedRenderVideo(paramBoolean1);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.a(paramBoolean2);
      this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentQavUiC2CVideoView.setVisibility(1);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(true);
      a(false, false);
    }
    while (!paramBoolean2) {
      return;
    }
    a(false);
    a(true, false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI
 * JD-Core Version:    0.7.0.1
 */