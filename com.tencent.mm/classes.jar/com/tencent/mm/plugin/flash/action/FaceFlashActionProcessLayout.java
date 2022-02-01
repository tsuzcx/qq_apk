package com.tencent.mm.plugin.flash.action;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONObject;

public class FaceFlashActionProcessLayout
  extends RelativeLayout
{
  static String BAm = "MicroMsg.FaceFlashManagerError";
  static String TAG = "MicroMsg.FaceFlashActionProcessLayout";
  private FaceFlashActionUI BAY;
  TextView BAn;
  WeImageView BAp;
  ImageView BAq;
  Button BAr;
  TextView BAs;
  Animation BAt;
  Animation BAu;
  Animation BAv;
  Button BBi;
  RelativeLayout BBj;
  float BBk;
  boolean BBl;
  
  public FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceFlashActionProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(190897);
    this.BAY = ((FaceFlashActionUI)getContext());
    this.BAt = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.face_flash_head_bg_scale);
    this.BAu = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.face_flash_head_success_scale);
    this.BAv = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.face_flash_head_fail_scale);
    LayoutInflater.from(getContext()).inflate(a.g.face_flash_action_upload_layout, this, true);
    this.BAn = ((TextView)findViewById(a.e.face_flash_header_tip));
    ar.a(this.BAn.getPaint(), 0.8F);
    this.BAp = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.BAr = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.BAs = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.BAq = ((ImageView)findViewById(a.e.face_flash_header_bg));
    this.BBi = ((Button)findViewById(a.e.face_flash_bottom_custom));
    this.BBj = ((RelativeLayout)findViewById(a.e.face_flash_header_layout));
    AppMethodBeat.o(190897);
  }
  
  public void setCircleY(float paramFloat)
  {
    this.BBk = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout
 * JD-Core Version:    0.7.0.1
 */