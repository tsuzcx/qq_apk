package com.tencent.mm.plugin.flash.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class FaceFlashActionProcessLayout
  extends RelativeLayout
{
  static String HhK = "MicroMsg.FaceFlashManagerError";
  static String TAG = "MicroMsg.FaceFlashActionProcessLayout";
  TextView HhL;
  WeImageView HhN;
  ImageView HhO;
  Button HhP;
  TextView HhQ;
  Animation HhR;
  Animation HhS;
  Animation HhT;
  Button HiK;
  RelativeLayout HiL;
  float HiM;
  boolean HiN;
  private FaceFlashActionUI Hiy;
  
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
    AppMethodBeat.i(264757);
    this.Hiy = ((FaceFlashActionUI)getContext());
    this.HhR = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_bg_scale);
    this.HhS = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_success_scale);
    this.HhT = AnimationUtils.loadAnimation(getContext(), a.a.face_flash_head_fail_scale);
    LayoutInflater.from(getContext()).inflate(a.g.face_flash_action_upload_layout, this, true);
    this.HhL = ((TextView)findViewById(a.e.face_flash_header_tip));
    aw.a(this.HhL.getPaint(), 0.8F);
    this.HhN = ((WeImageView)findViewById(a.e.face_flash_header_icon));
    this.HhP = ((Button)findViewById(a.e.face_flash_bottom_verify));
    this.HhQ = ((TextView)findViewById(a.e.face_flash_bottom_feedback));
    this.HhO = ((ImageView)findViewById(a.e.face_flash_header_bg));
    this.HiK = ((Button)findViewById(a.e.face_flash_bottom_custom));
    this.HiL = ((RelativeLayout)findViewById(a.e.face_flash_header_layout));
    AppMethodBeat.o(264757);
  }
  
  public void setCircleY(float paramFloat)
  {
    this.HiM = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout
 * JD-Core Version:    0.7.0.1
 */