package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;

public class FaceNumberView
  extends LinearLayout
{
  private String jUX = null;
  private int jUY;
  private ViewGroup jUZ = (ViewGroup)inflate(getContext(), a.g.face_number_view, null);
  public FaceNumberItemView[] jVa = null;
  private int jVb = 0;
  private Animation jVc = null;
  private FaceNumberView.a jVd = FaceNumberView.a.jVf;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    addView(this.jUZ);
    this.jVc = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
  }
  
  private static void a(FaceNumberItemView paramFaceNumberItemView, String paramString)
  {
    if (paramFaceNumberItemView == null) {
      return;
    }
    if (paramString.equals("0"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number0);
      return;
    }
    if (paramString.equals("1"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number1);
      return;
    }
    if (paramString.equals("2"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number2);
      return;
    }
    if (paramString.equals("3"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number3);
      return;
    }
    if (paramString.equals("4"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number4);
      return;
    }
    if (paramString.equals("5"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number5);
      return;
    }
    if (paramString.equals("6"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number6);
      return;
    }
    if (paramString.equals("7"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number7);
      return;
    }
    if (paramString.equals("8"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number8);
      return;
    }
    if (paramString.equals("9"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number9);
      return;
    }
    paramFaceNumberItemView.setImageResource(a.d.face_point);
  }
  
  public final void Ct(String paramString)
  {
    int i = 0;
    this.jUX = paramString;
    label52:
    FaceNumberItemView localFaceNumberItemView;
    if (this.jUX != null)
    {
      this.jUY = this.jUX.length();
      if ((this.jVa == null) || (this.jVa.length <= 0)) {
        return;
      }
      if (bk.bl(this.jUX)) {
        break label221;
      }
      i = 0;
      if (i >= this.jVa.length) {
        return;
      }
      if (this.jUY <= i) {
        break label215;
      }
      paramString = this.jUX.charAt(i);
      if (this.jUY != i + 1) {
        break label186;
      }
      localFaceNumberItemView = this.jVa[i];
      if (localFaceNumberItemView.jUM != null) {
        localFaceNumberItemView.aPv();
      }
      localFaceNumberItemView.jUM = new Timer("FaceNumberItemView_karaoke", true);
      FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView, localFaceNumberItemView.jUU, (byte)0);
      localFaceNumberItemView.jUM.scheduleAtFixedRate(locala, 0L, FaceNumberItemView.jUN);
    }
    for (;;)
    {
      a(this.jVa[i], paramString);
      i += 1;
      break label52;
      this.jUY = 0;
      break;
      label186:
      this.jVa[i].aPv();
      localFaceNumberItemView = this.jVa[i];
      localFaceNumberItemView.jUT = 30;
      localFaceNumberItemView.invalidate();
      continue;
      label215:
      paramString = "";
    }
    label221:
    while (i < this.jVa.length)
    {
      a(this.jVa[i], "point");
      i += 1;
    }
  }
  
  public void setNumberLengthAndInflate(int paramInt)
  {
    if (paramInt > 12)
    {
      y.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramInt <= 0)
    {
      y.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramInt == this.jVb)
    {
      y.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      Ct(null);
      return;
    }
    this.jUZ.removeAllViews();
    this.jVb = paramInt;
    this.jVa = new FaceNumberItemView[this.jVb];
    int k = 0;
    label95:
    FaceNumberItemView localFaceNumberItemView;
    int j;
    int i;
    if (k < paramInt)
    {
      localFaceNumberItemView = (FaceNumberItemView)inflate(getContext(), a.g.face_number_view_item, null);
      localFaceNumberItemView.setImageResource(a.d.face_point);
      if (k != 0) {
        break label206;
      }
      j = 3;
      i = (getResources().getDimensionPixelSize(a.c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
    }
    for (;;)
    {
      localFaceNumberItemView.setGravity(j);
      this.jVa[k] = localFaceNumberItemView;
      this.jUZ.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(a.c.face_number_height)));
      k += 1;
      break label95;
      break;
      label206:
      if (k == paramInt - 1)
      {
        j = 5;
        i = (getResources().getDimensionPixelSize(a.c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
      }
      else
      {
        j = 17;
        i = getResources().getDimensionPixelSize(a.c.face_number_width);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */