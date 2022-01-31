package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

@SuppressLint({"ValidFragment"})
public final class c$c
  extends Fragment
{
  private View iUL = null;
  private Button jSk = null;
  private WeakReference<c> jSl;
  
  public c$c(c paramc)
  {
    y.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
    this.jSl = new WeakReference(paramc);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    y.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    y.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
    this.iUL = paramLayoutInflater.inflate(a.g.face_tutorial_fragment_2, paramViewGroup, false);
    this.jSk = ((Button)this.iUL.findViewById(a.e.face_tt_confirm_btn));
    this.jSk.setOnClickListener(new c.c.1(this));
    return this.iUL;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.c.c
 * JD-Core Version:    0.7.0.1
 */